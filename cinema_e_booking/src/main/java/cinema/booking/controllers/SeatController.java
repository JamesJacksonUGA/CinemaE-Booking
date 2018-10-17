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

import cinema.booking.models.Seat;
import cinema.booking.services.SeatService;

@RestController
public class SeatController {

	@Autowired
	private SeatService seatService;
	
	
	@GetMapping("/seat")
	public List<Seat> getAllSeats() {
		return seatService.getAllSeats();
	}
	
	@GetMapping("/seat/{seatId}")
	public Optional<Seat> getSeatById(@PathVariable Integer seatId) {
		return seatService.getSeatById(seatId);
	}
	
	@PostMapping("/seat")
	public void addSeat(@RequestBody Seat seat) {
		seatService.addSeat(seat);
	}
	
	@PutMapping("/seat/{seatId}")
	public void updateSeat(@RequestBody Seat seat, @PathVariable Integer seatId) {
		seatService.updateSeat(seat);
	}
	
	@DeleteMapping("seat/{seatId}")
	public void deleteSeatById(@PathVariable Integer seatId) {
		seatService.deleteSeatById(seatId);
	}
	
}
