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

import cinema.booking.models.Theater;
import cinema.booking.services.TheaterService;

@RestController
public class TheaterController {

	@Autowired
	private TheaterService theaterService;
	
	
	@GetMapping("/theater")
	public List<Theater> getAllTheaters() {
		return theaterService.getAllTheaters();
	}
	
	@GetMapping("/theater/{theaterId}")
	public Optional<Theater> getTheaterById(@PathVariable Integer theaterId) {
		return theaterService.getTheaterById(theaterId);
	}
	
	@PostMapping("/theater")
	public void addTheater(@RequestBody Theater theater) {
		theaterService.addTheater(theater);
	}
	
	@PutMapping("/theater/{theaterId}")
	public void updateTheater(@RequestBody Theater theater, @PathVariable Integer theaterId) {
		theaterService.updateTheater(theater);
	}
	
	@DeleteMapping("theater/{theaterId}")
	public void deleteTheaterById(@PathVariable Integer theaterId) {
		theaterService.deleteTheaterById(theaterId);
	}
	
}
