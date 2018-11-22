package cinema.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.Movie;
import cinema.booking.rowMapper.MovieRowMapper;
import cinema.booking.services.MovieService;
import cinema.booking.services.ShowtimeService;

@Controller
public class MovieDetailsController {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Autowired
    private MovieService movieService;
	
	@Autowired
    private ShowtimeService showtimeService;

	@RequestMapping(value= {"/movieDetails/{movie_id}"})
	public String movieDetails(@PathVariable("movie_id") Integer movie_id, Model model) {
		model.addAttribute("allShowtimes", showtimeService.getShowtimeByMovieId(movie_id));
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movies", o));
	
		return "movieDetails";
	}
	
	@RequestMapping(value= {"/movieDetails/{movie_id}/{date}"})
	public String movieDetailsDate(@PathVariable("movie_id") Integer movie_id, 
			@PathVariable("date") String date,
			Model model) {
		movieService.getMovieById(movie_id).ifPresent(o -> model.addAttribute("movies", o));
		model.addAttribute("showtimes", showtimeService.findShowtimeByDate(date, movie_id));
		
	
		return "movieDetails";
	}
	
	@RequestMapping(value= {"/deleteMovieDetails/{movie_id}"})
	public String deleteMovieDetails(@PathVariable("movie_id") Integer movie_id, Model model) {
		Movie movie = movieService.findMovieById(movie_id);
		movieService.deleteMovieById(movie.getMovieId());
		
		String query = "SELECT * FROM movie WHERE coming_soon=0";
		List<Movie> movies = jdbcTemplate.query(query, new MovieRowMapper());
				
		model.addAttribute("movies", movies);
		
		model.addAttribute("deletedMovie", "true");
		return "movies";
	}
	
}




