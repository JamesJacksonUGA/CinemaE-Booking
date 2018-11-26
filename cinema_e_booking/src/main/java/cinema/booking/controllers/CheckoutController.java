package cinema.booking.controllers;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.Booking;
import cinema.booking.models.CheckoutForm;
import cinema.booking.models.PaymentInfo;
import cinema.booking.models.Promotion;
import cinema.booking.models.Seat;
import cinema.booking.models.Showtime;
import cinema.booking.models.Ticket;
import cinema.booking.models.User;
import cinema.booking.services.BookingService;
import cinema.booking.services.MailService;
import cinema.booking.services.MovieService;
import cinema.booking.services.PaymentInfoService;
import cinema.booking.services.PromotionService;
import cinema.booking.services.SeatService;
import cinema.booking.services.ShowtimeService;
import cinema.booking.services.TicketService;
import cinema.booking.services.TicketTypeService;
import cinema.booking.services.UserService;

@Controller
public class CheckoutController {

	@Value("${server.port}")
	String port;
	@Autowired
	private MovieService movieService;
	@Autowired
	private ShowtimeService showtimeService;	
	@Autowired
	private UserService userService;	
	@Autowired
	private TicketTypeService ticketTypeService;
	@Autowired
	private PromotionService promotionService;
	@Autowired
	private PaymentInfoService paymentInfoService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private SeatService seatService;
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping(value="/checkout")
	public String checkout(Model model) {
		return "checkout";
	}
	
	@RequestMapping(value="/checkout/{movie_id}/{showtime_id}/{adult}/{child}/{senior}/{selectedSeats}")
	public String getCheckout( 
			@PathVariable("movie_id") Integer movie_id, 
			@PathVariable("showtime_id") Integer showtime_id, 
			@PathVariable("selectedSeats") String selectedSeats,
			@PathVariable("adult") Integer adult,
			@PathVariable("child") Integer child, 
			@PathVariable("senior") Integer senior, 
			Model model) {
		
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		showtimeService.getShowtimeById(showtime_id).ifPresent(o -> model.addAttribute("showtime", o));
		model.addAttribute("totalTickets", (adult + child + senior));
		model.addAttribute("adult", adult);
		model.addAttribute("child", child);
		model.addAttribute("senior", senior);
		
		//calculate total price
		double tax = ticketTypeService.getPriceByType("TAX");
		double fee = ticketTypeService.getPriceByType("FEE");
		double adultTotal = adult*ticketTypeService.getPriceByType("ADULT") + tax + fee;
		double childTotal = child*ticketTypeService.getPriceByType("CHILD") + tax + fee;
		double seniorTotal = senior*ticketTypeService.getPriceByType("SENIOR") + tax + fee;
		DecimalFormat d = new DecimalFormat("#.00");
		model.addAttribute("total", d.format(adultTotal + childTotal + seniorTotal + tax + fee));
		
		model.addAttribute("selectedSeats", selectedSeats);
		
		model.addAttribute("adultPrice", ticketTypeService.getPriceByType("ADULT"));
		model.addAttribute("childPrice", ticketTypeService.getPriceByType("CHILD"));
		model.addAttribute("seniorPrice", ticketTypeService.getPriceByType("SENIOR"));
		model.addAttribute("tax", tax);
		model.addAttribute("fee", fee);
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		model.addAttribute("checkoutForm", new CheckoutForm());
		
		return "checkout";
	}
	
	@PostMapping(value="/checkout/{movie_id}/{showtime_id}/{adult}/{child}/{senior}/{selectedSeats}")
	public String postCheckout(
			@ModelAttribute CheckoutForm checkoutForm,
			@PathVariable("movie_id") Integer movie_id, 
			@PathVariable("showtime_id") Integer showtime_id, 
			@PathVariable("selectedSeats") String selectedSeats,
			@PathVariable("adult") Integer adult,
			@PathVariable("child") Integer child, 
			@PathVariable("senior") Integer senior, 
			Model model) {
		
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		showtimeService.getShowtimeById(showtime_id).ifPresent(o -> model.addAttribute("showtime", o));
		model.addAttribute("totalTickets", (adult + child + senior));
		model.addAttribute("adult", adult);
		model.addAttribute("child", child);
		model.addAttribute("senior", senior);
		
		//calculate total price
		double tax = ticketTypeService.getPriceByType("TAX");
		double fee = ticketTypeService.getPriceByType("FEE");
		double adultTotal = adult*ticketTypeService.getPriceByType("ADULT") + tax + fee;
		double childTotal = child*ticketTypeService.getPriceByType("CHILD") + tax + fee;
		double seniorTotal = senior*ticketTypeService.getPriceByType("SENIOR") + tax + fee;
		double total = adultTotal + childTotal + seniorTotal + tax + fee;
		
		//handle promotion if there is one
		if (checkoutForm.getPromoCode() == "") {
			
		}
		else if (checkoutForm.getPromoCode() != null
				&& promotionService.getPromotionByPromoCode(checkoutForm.getPromoCode()) != null) {
			//if user entered a correct promo code
			Promotion promotion = promotionService.getPromotionByPromoCode(checkoutForm.getPromoCode());
			double percentOff = promotion.getPercentOff();
			double amountOff = total * (percentOff/100);
			total = total - (total*(percentOff/100));
			
			model.addAttribute("promoCode", checkoutForm.getPromoCode());
			model.addAttribute("amountOff", amountOff);
			model.addAttribute("percentOff", percentOff);
		}
		else if (checkoutForm.getPromoCode() != null
				&& promotionService.getPromotionByPromoCode(checkoutForm.getPromoCode()) == null) {
			//if user entered an incorrect promo code
			model.addAttribute("incorrectCode", true);
			return "redirect:/checkout/" + movie_id + "/" + showtime_id + "/" + adult + "/" + child + "/" + senior + "/" + selectedSeats + "/error";
		}
		
		DecimalFormat d = new DecimalFormat("#.00");
		model.addAttribute("total", d.format(total));
		
		model.addAttribute("selectedSeats", selectedSeats);
		
		model.addAttribute("adultPrice", ticketTypeService.getPriceByType("ADULT"));
		model.addAttribute("childPrice", ticketTypeService.getPriceByType("CHILD"));
		model.addAttribute("seniorPrice", ticketTypeService.getPriceByType("SENIOR"));
		model.addAttribute("tax", tax);
		model.addAttribute("fee", fee);
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		model.addAttribute("checkoutForm", checkoutForm);
		
		return "checkoutConfirmation";
	}
	
	@RequestMapping(value="/checkout/{movie_id}/{showtime_id}/{adult}/{child}/{senior}/{selectedSeats}/error")
	public String getCheckoutError( 
			@PathVariable("movie_id") Integer movie_id, 
			@PathVariable("showtime_id") Integer showtime_id, 
			@PathVariable("selectedSeats") String selectedSeats,
			@PathVariable("adult") Integer adult,
			@PathVariable("child") Integer child, 
			@PathVariable("senior") Integer senior, 
			Model model) {
		
		model.addAttribute("incorrectCode", "true");
		
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		showtimeService.getShowtimeById(showtime_id).ifPresent(o -> model.addAttribute("showtime", o));
		model.addAttribute("totalTickets", (adult + child + senior));
		model.addAttribute("adult", adult);
		model.addAttribute("child", child);
		model.addAttribute("senior", senior);
		
		//calculate total price
		double tax = ticketTypeService.getPriceByType("TAX");
		double fee = ticketTypeService.getPriceByType("FEE");
		double adultTotal = adult*ticketTypeService.getPriceByType("ADULT") + tax + fee;
		double childTotal = child*ticketTypeService.getPriceByType("CHILD") + tax + fee;
		double seniorTotal = senior*ticketTypeService.getPriceByType("SENIOR") + tax + fee;
		DecimalFormat d = new DecimalFormat("#.00");
		model.addAttribute("total", d.format(adultTotal + childTotal + seniorTotal + tax + fee));
		
		model.addAttribute("selectedSeats", selectedSeats);
		
		model.addAttribute("adultPrice", ticketTypeService.getPriceByType("ADULT"));
		model.addAttribute("childPrice", ticketTypeService.getPriceByType("CHILD"));
		model.addAttribute("seniorPrice", ticketTypeService.getPriceByType("SENIOR"));
		model.addAttribute("tax", tax);
		model.addAttribute("fee", fee);
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		model.addAttribute("checkoutForm", new CheckoutForm());
		
		return "checkout";
	}
	
	@RequestMapping(value="/checkoutConfirmation")
	public String getCheckoutConfirmation(Model model) {
		return "checkoutConfirmation";
	}
	
	@PostMapping(value="/checkoutConfirmation/{movie_id}/{showtime_id}/{adult}/{child}/{senior}/{selectedSeats}")
	public String postCheckoutConfirmation(
			@ModelAttribute CheckoutForm checkoutForm,
			@PathVariable("movie_id") Integer movie_id, 
			@PathVariable("showtime_id") Integer showtime_id, 
			@PathVariable("selectedSeats") String selectedSeats,
			@PathVariable("adult") Integer adult,
			@PathVariable("child") Integer child, 
			@PathVariable("senior") Integer senior, 
			Model model) {
		
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
				
		
		//create payment
		PaymentInfo paymentInfo = new PaymentInfo(checkoutForm.getCcnum(), 
				checkoutForm.getCVV(),
				checkoutForm.getExpDate(),
				user,
				checkoutForm.getAddress(),
				checkoutForm.getAddress2(),
				checkoutForm.getCountry(),
				checkoutForm.getState(),
				checkoutForm.getZip(),
				checkoutForm.getCardholderName());
		paymentInfoService.addPaymentInfo(paymentInfo);
		
		
		//get show time
		Showtime showtime = showtimeService.findShowtimeById(showtime_id);
		
		Booking booking;
		
		//get promotion if there is one
		if (checkoutForm.getPromoCode() != null) {
			Promotion promotion = promotionService.getPromotionByPromoCode(checkoutForm.getPromoCode());
			
			//create booking with promotion
			booking = new Booking(user, promotion, showtime, paymentInfo);
			bookingService.addBooking(booking);
		}
		else {
			//create booking without promotion
			booking = new Booking(user, showtime, paymentInfo);
			bookingService.addBooking(booking);
		}
		
		
		String[] seatNumbers = selectedSeats.split("\\-");	
		
		double tax = ticketTypeService.getPriceByType("TAX");
		double fee = ticketTypeService.getPriceByType("FEE");
		
		//create adult tickets
		double adultSellingPrice = ticketTypeService.getPriceByType("ADULT") + tax + fee;
		Integer adultTypeId = ticketTypeService.getTicketTypeIdByType("ADULT");
		for (int i = 0; i < adult; i++) {
			String seatNumber = showtimeService.findTheaterIdByShowtimeId(showtime_id) + seatNumbers[i];
			Ticket ticket = new Ticket(booking, seatNumber, adultTypeId, adultSellingPrice);
			ticketService.addTicket(ticket);
			
			//update seat corresponding with ticket
			Seat seat = seatService.findBySeatNoShowtimeId(seatNumber, showtime_id);
			seat.setTaken(true);
			seat.setBooking(booking);
			seatService.updateSeat(seat);
		}
		
		//create child tickets
		double childSellingPrice = ticketTypeService.getPriceByType("CHILD") + tax + fee;
		Integer childTypeId = ticketTypeService.getTicketTypeIdByType("CHILD");
		for (int i = 0; i < child; i++) {
			String seatNumber = showtimeService.findTheaterIdByShowtimeId(showtime_id) + seatNumbers[adult + i];
			Ticket ticket = new Ticket(booking, seatNumber, childTypeId, childSellingPrice);
			ticketService.addTicket(ticket);
			
			//update seat corresponding with ticket
			Seat seat = seatService.findBySeatNoShowtimeId(seatNumber, showtime_id);
			seat.setTaken(true);
			seat.setBooking(booking);
			seatService.updateSeat(seat);
		}
		
		//create senior tickets
		double seniorSellingPrice = ticketTypeService.getPriceByType("SENIOR") + tax + fee;
		Integer seniorTypeId = ticketTypeService.getTicketTypeIdByType("SENIOR");
		for (int i = 0; i < senior; i++) {
			String seatNumber = showtimeService.findTheaterIdByShowtimeId(showtime_id) + seatNumbers[adult + child + i];
			Ticket ticket = new Ticket(booking, seatNumber, seniorTypeId, seniorSellingPrice);
			ticketService.addTicket(ticket);
			
			//update seat corresponding with ticket
			Seat seat = seatService.findBySeatNoShowtimeId(seatNumber, showtime_id);
			seat.setTaken(true);
			seat.setBooking(booking);
			seatService.updateSeat(seat);
		}
		
		
		//send confirmation email with tickets
		String subject = "Athens Tickets Order Confirmation";
		String text = "Thank you for your order, your payment has been confirmed.\n";
		
		try {
			mailService.sendSimpleMessage(user.getEmail(), subject, text);
			model.addAttribute("checkout", "true");
			return "homepage";
		}
		catch (MailException e) {
			System.out.println("Could not send message");
			
			model.addAttribute("failedToSendCheckout", "true");
			return "homepage";
		}
		
	}
	
}





