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

import cinema.booking.models.Booking;
import cinema.booking.services.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	@GetMapping("/booking")
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/booking/{bookingId}")
	public Optional<Booking> getBookingById(@PathVariable Integer bookingId) {
		return bookingService.getBookingById(bookingId);
	}
	
	@PostMapping("/booking")
	public void addBooking(@RequestBody Booking booking) {
		bookingService.addBooking(booking);
	}
	
	@PutMapping("/booking/{bookingId}")
	public void updateBooking(@RequestBody Booking booking, @PathVariable Integer bookingId) {
		bookingService.updateBooking(booking);
	}
	
	@DeleteMapping("booking/{bookingId}")
	public void deleteBookingById(@PathVariable Integer bookingId) {
		bookingService.deleteBookingById(bookingId);
	}
	
}
