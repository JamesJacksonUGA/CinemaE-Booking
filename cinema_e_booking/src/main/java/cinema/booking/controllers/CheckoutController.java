package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.User;
import cinema.booking.services.MovieService;
import cinema.booking.services.ShowtimeService;
import cinema.booking.services.TicketTypeService;
import cinema.booking.services.UserService;

@Controller
public class CheckoutController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ShowtimeService showtimeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TicketTypeService ticketTypeService;
	
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
		
		model.addAttribute("adultPrice", ticketTypeService.getPriceByType("ADULT"));
		model.addAttribute("childPrice", ticketTypeService.getPriceByType("CHILD"));
		model.addAttribute("seniorPrice", ticketTypeService.getPriceByType("SENIOR"));
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		
		return "checkout";
	}
	
}


