package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.repositories.ShowtimeRepository;
import cinema.booking.services.MovieService;
import cinema.booking.services.TheaterService;

@Controller
public class BookController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private TheaterService theaterService;
	@Autowired
	private ShowtimeRepository showtimeRepository;
	
	@RequestMapping(value="/book")
	public String book(Model model) {
		model.addAttribute("movies", movieService.getAllMovies());
		
		return "book";
	}
	
	@RequestMapping(value="/book/{movie_id}")
	public String book(@PathVariable("movie_id") Integer movie_id, Model model) {
				
		//unwrap Optional<Movie> object before adding to model
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		model.addAttribute("theaters", theaterService.getAllTheaters());
		model.addAttribute("movies", movieService.getAllMovies());
		
		return "book";
	}
	
	@RequestMapping(value="/book/{movie_id}/{theater_id}")
	public String book(@PathVariable("movie_id") Integer movie_id, @PathVariable("theater_id") Integer theater_id, Model model) {
				
		//unwrap Optional<Movie> object before adding to model
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		model.addAttribute("theaters", theaterService.getAllTheaters());
		theaterService.getTheaterById(theater_id).ifPresent(o -> model.addAttribute("theater", o));
		model.addAttribute("showtimes", showtimeRepository.findByTheaterIdMovieId(theater_id, movie_id));
		model.addAttribute("movies", movieService.getAllMovies());
		
		return "book";
	}
	
	@RequestMapping(value="/book/{movie_id}/{theater_id}/{showtime_id}")
	public String book(@PathVariable("movie_id") Integer movie_id, @PathVariable("theater_id") Integer theater_id, @PathVariable("showtime_id") Integer showtime_id, Model model) {
				
		//unwrap Optional<Movie> object before adding to model
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movie", o));
		model.addAttribute("theaters", theaterService.getAllTheaters());
		theaterService.getTheaterById(theater_id).ifPresent(o -> model.addAttribute("theater", o));
		model.addAttribute("showtimes", showtimeRepository.findByTheaterIdMovieId(theater_id, movie_id));
		model.addAttribute("movies", movieService.getAllMovies());
		
		return "checkout";
	}
	
}







