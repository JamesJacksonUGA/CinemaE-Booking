package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Seat;
import cinema.booking.repositories.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;
	
	
	public List<Seat> getAllSeats() {
		List<Seat> seats = new ArrayList<>();
		seatRepository.findAll().forEach(seats::add);
		return seats;
	}

	public Optional<Seat> getSeatById(Integer seatId) {
		return seatRepository.findById(seatId);
	}
	
	public Seat findBySeatNoShowtimeId(String seatNo, Integer showtimeId) {
		return seatRepository.findBySeatNoShowtimeId(seatNo, showtimeId);
	}
	
	public List<Seat> getSeatsByShowtimeId(Integer showtimeId) {
		return seatRepository.getSeatsByShowtimeId(showtimeId);
	}
	
	public void addSeat(Seat seat) {
		seatRepository.save(seat);
	}
	
	public void updateSeat(Seat seat) {
		seatRepository.save(seat);
	}
	
	public void deleteSeatById(Integer seatId) {
		seatRepository.deleteById(seatId);
	}
	
}
