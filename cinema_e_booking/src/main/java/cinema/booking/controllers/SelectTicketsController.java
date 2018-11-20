package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.TicketTypeSelection;
import cinema.booking.services.MovieService;
import cinema.booking.services.ShowtimeService;

@Controller
public class SelectTicketsController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ShowtimeService showtimeService;
	
	@RequestMapping(value="/selectTickets")
	public String getSelectTickets() {
		return "selectTickets";
	}
	
	@RequestMapping(value="/selectTicketTypes")
	public String getSelectTicketTypes() {
		return "selectTickets";
	}

	@RequestMapping(value="/selectTickets/{movie_id}/{showtime_id}")
	public String selectTickets(@PathVariable("movie_id") Integer movie_id, 
			@PathVariable("showtime_id") Integer showtime_id, 
			Model model) {
				
		//unwrap Optional<Movie> object before adding to model
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		showtimeService.getShowtimeById(showtime_id).ifPresent(o -> model.addAttribute("showtime", o));
		
		model.addAttribute("ticketTypes", new TicketTypeSelection());
		return "selectTickets";
	}
	
	@PostMapping(value="/selectTicketTypes/{movie_id}/{showtime_id}")
	public String selectTicketTypes(@ModelAttribute("ticketTypes") TicketTypeSelection ticketTypes, 
			@PathVariable("movie_id") Integer movie_id, 
			@PathVariable("showtime_id") Integer showtime_id, 
			Model model) {
		ticketTypes.setTotal(ticketTypes.getAdult()
				+ ticketTypes.getChild()
				+ ticketTypes.getSenior());
		model.addAttribute("ticketTypes", ticketTypes);
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		showtimeService.getShowtimeById(showtime_id).ifPresent(o -> model.addAttribute("showtime", o));
		
		model.addAttribute("selectedSeats", new String());
		
		//direct to seat selection page
		return "seatSelection";
	}
	
}









