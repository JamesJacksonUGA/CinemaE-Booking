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

import cinema.booking.models.TheaterMovie;
import cinema.booking.services.TheaterMovieService;

@RestController
public class TheaterMovieController {

	@Autowired
	private TheaterMovieService theaterMovieService;
	
	
	@GetMapping("/theaterMovie")
	public List<TheaterMovie> getAllTheaterMovies() {
		return theaterMovieService.getAllTheaterMovies();
	}
	
	@GetMapping("/theaterMovie/{theaterMovieId}")
	public Optional<TheaterMovie> getTheaterMovieById(@PathVariable Integer theaterMovieId) {
		return theaterMovieService.getTheaterMovieById(theaterMovieId);
	}
	
	@PostMapping("/theaterMovie")
	public void addTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
		theaterMovieService.addTheaterMovie(theaterMovie);
	}
	
	@PutMapping("/theaterMovie/{theaterMovieId}")
	public void updateTheaterMovie(@RequestBody TheaterMovie theaterMovie, @PathVariable Integer theaterMovieId) {
		theaterMovieService.updateTheaterMovie(theaterMovie);
	}
	
	@DeleteMapping("theaterMovie/{theaterMovieId}")
	public void deleteTheaterMovieById(@PathVariable Integer theaterMovieId) {
		theaterMovieService.deleteTheaterMovieById(theaterMovieId);
	}
	
}
