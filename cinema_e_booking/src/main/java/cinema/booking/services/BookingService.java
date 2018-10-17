package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Booking;
import cinema.booking.repositories.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	
	public List<Booking> getAllBookings() {
		List<Booking> bookings = new ArrayList<>();
		bookingRepository.findAll().forEach(bookings::add);
		return bookings;
	}

	public Optional<Booking> getBookingById(Integer bookingId) {
		return bookingRepository.findById(bookingId);
	}
	
	public void addBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public void updateBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public void deleteBookingById(Integer bookingId) {
		bookingRepository.deleteById(bookingId);
	}
	
}
