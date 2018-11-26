package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.Movie;
import cinema.booking.services.MovieService;

@Controller
public class EditMovieDetailsController {
	@Autowired
    private MovieService movieService;

	@RequestMapping(value= {"/editMovieDetails"})
	public String movieDetails(Model model) {
				
		return "editMovieDetails";
	}
	
	@RequestMapping(value= {"/editMovieDetails/{movie_id}"})
	public String movieDetails(@PathVariable("movie_id") Integer movie_id, Model model) {
		
		model.addAttribute("movie", movieService.findMovieById(movie_id));
		
		return "editMovieDetails";
	}
	
	@PostMapping(value= {"/editMovieDetails/{movie_id}"})
	public String editMovieDetails(@PathVariable("movie_id") Integer movie_id, 
			@RequestParam String title,
			@RequestParam Integer length,
			@RequestParam String category,
			@RequestParam String synopsis,
			@RequestParam String director,
			@RequestParam String producer,
			@RequestParam String cast,
			@RequestParam String video,
			Model model) {
		
		Movie movie = movieService.findMovieById(movie_id);
		movie.setTitle(title);
		movie.setCategory(category);
		movie.setLength(length);
		movie.setSynopsis(synopsis);
		movie.setDirector(director);
		movie.setProducer(producer);
		movie.setCast(cast);
		if (!video.equals("")) {
			movie.setVideo(video);
		}
		movieService.updateMovie(movie);
		
		model.addAttribute("movie", movieService.findMovieById(movie_id));
		return "editMovieDetails";
	}
	
}
