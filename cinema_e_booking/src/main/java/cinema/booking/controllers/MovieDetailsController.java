package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.services.MovieService;
import cinema.booking.services.ShowtimeService;

@Controller
public class MovieDetailsController {

	@Autowired
    private MovieService movieService;
	
	@Autowired
    private ShowtimeService showtimeService;

	@RequestMapping(value= {"/movieDetails/{movie_id}"})
	public String movieDetails(@PathVariable("movie_id") Integer movie_id, Model model) {
		model.addAttribute("showtimes", showtimeService.getShowtimeByMovieId(movie_id));
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movies", o));
	
		return "movieDetails";
	}
	
}
