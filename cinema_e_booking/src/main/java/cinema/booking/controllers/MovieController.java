package cinema.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.booking.models.Movie;
import cinema.booking.services.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/movie")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/movie/{movieId}")
	public Optional<Movie> getMovieById(@PathVariable Integer movieId) {
		return movieService.getMovieById(movieId);
	}
	
	@PostMapping("/movie")
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
	}
	
	@PutMapping("/movie/{movieId}")
	public void updateMovie(@RequestBody Movie movie, @PathVariable Integer movieId) {
		movieService.updateMovie(movie);
	}
	
	@DeleteMapping("movie/{movieId}")
	public void deleteMovieById(@PathVariable Integer movieId) {
		movieService.deleteMovieById(movieId);
	}
	
}
