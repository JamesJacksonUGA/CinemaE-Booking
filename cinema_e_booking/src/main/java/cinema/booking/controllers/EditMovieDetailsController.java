package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.services.MovieService;

@Controller
public class EditMovieDetailsController {
	@Autowired
    private MovieService movieService;

	@RequestMapping(value= {"/editMovieDetails/{movie_id}"})
	public String movieDetails(@PathVariable("movie_id") Integer movie_id, Model model) {
		
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movies", o));
	
		return "editMovieDetails";
	}
}
