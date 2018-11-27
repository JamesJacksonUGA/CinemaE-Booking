package cinema.booking.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.Booking;
import cinema.booking.models.Movie;
import cinema.booking.models.PaymentInfo;
import cinema.booking.models.RecentPurchase;
import cinema.booking.models.Showtime;
import cinema.booking.models.User;
import cinema.booking.services.BookingService;
import cinema.booking.services.PaymentInfoService;
import cinema.booking.services.ShowtimeService;
import cinema.booking.services.TicketService;
import cinema.booking.services.TicketTypeService;
import cinema.booking.services.UserService;

@Controller
public class RecentPurchasesController {

	@Autowired
	private UserService userService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private ShowtimeService showtimeService;
	@Autowired
	private PaymentInfoService paymentInfoService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private TicketTypeService ticketTypeService;
	
	
	@RequestMapping(value="/recentPurchases")
	public String recentPurchases(Model model) {
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		
		//get all bookings for user
		List<Booking> bookings = bookingService.findBookingsByUserId(user.getUserId());
		List<RecentPurchase> recentPurchases = new ArrayList<RecentPurchase>();
		
		for (int i = 0; i < bookings.size(); i++) {
			
			Integer bookingId = bookings.get(i).getBookingId();
			
			//add current bookings showtime to showtime list
			Showtime showtime = showtimeService.findShowtimeById(
					bookingService.findShowtimeIdByBookingId(bookingId));
			
			//add current bookings payment info to payment info list
			PaymentInfo paymentInfo = paymentInfoService.findPaymentInfoById(
					bookingService.findPaymentInfoIdByBookingId(bookingId));
			
			//add current bookings movie to movies list
			Movie movie = showtime.getMovie();
			
			//get all tickets from the booking
			Integer adult = ticketService.getAdultByBookingId(bookingId);
			Integer child = ticketService.getChildByBookingId(bookingId);
			Integer senior = ticketService.getSeniorByBookingId(bookingId);
			
			double adultPrice = ticketTypeService.getPriceByType("ADULT");
			double childPrice = ticketTypeService.getPriceByType("CHILD");
			double seniorPrice = ticketTypeService.getPriceByType("SENIOR");
			double tax = ticketTypeService.getPriceByType("TAX");
			double fee = ticketTypeService.getPriceByType("FEE");
			
			if (adult > 0) {
				adultPrice = ticketService.getAdultSellingPrice(bookingId);
			}
			if (child > 0) {
				childPrice = ticketService.getChildSellingPrice(bookingId);
			}
			if (senior > 0) {
				seniorPrice = ticketService.getSeniorSellingPrice(bookingId);
			}
			double total = (adult*adultPrice) + (child*childPrice) + (senior*seniorPrice) + tax + fee;
			
			RecentPurchase recentPurchase = new RecentPurchase(
					movie.getTitle(),
					showtime.getDateTime(),
					adult,
					child,
					senior,
					adultPrice,
					childPrice,
					seniorPrice,
					total,
					paymentInfo.getAddress(),
					paymentInfo.getAddress2(),
					paymentInfo.getCountry(),
					paymentInfo.getState(),
					paymentInfo.getZip(),
					paymentInfo.getCcNum());
			recentPurchases.add(recentPurchase);
			
		}
		
		model.addAttribute("recentPurchases", recentPurchases);
		
		return "recentPurchases";
	}

}









