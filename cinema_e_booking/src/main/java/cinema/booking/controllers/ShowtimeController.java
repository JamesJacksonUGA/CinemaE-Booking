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

import cinema.booking.models.Showtime;
import cinema.booking.services.ShowtimeService;

@RestController
public class ShowtimeController {

	@Autowired
	private ShowtimeService showtimeService;
	
	
	@GetMapping("/showtime")
	public List<Showtime> getAllShowtimes() {
		return showtimeService.getAllShowtimes();
	}
	
	@GetMapping("/showtime/{showtimeId}")
	public Optional<Showtime> getShowtimeById(@PathVariable Integer showtimeId) {
		return showtimeService.getShowtimeById(showtimeId);
	}
	
	@PostMapping("/showtime")
	public void addShowtime(@RequestBody Showtime showtime) {
		showtimeService.addShowtime(showtime);
	}
	
	@PutMapping("/showtime/{showtimeId}")
	public void updateShowtime(@RequestBody Showtime showtime, @PathVariable Integer showtimeId) {
		showtimeService.updateShowtime(showtime);
	}
	
	@DeleteMapping("showtime/{showtimeId}")
	public void deleteShowtimeById(@PathVariable Integer showtimeId) {
		showtimeService.deleteShowtimeById(showtimeId);
	}
	
}
