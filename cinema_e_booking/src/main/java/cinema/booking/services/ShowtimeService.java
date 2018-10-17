package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Showtime;
import cinema.booking.repositories.ShowtimeRepository;

@Service
public class ShowtimeService {

	@Autowired
	private ShowtimeRepository showtimeRepository;
	
	
	public List<Showtime> getAllShowtimes() {
		List<Showtime> showtimes = new ArrayList<>();
		showtimeRepository.findAll().forEach(showtimes::add);
		return showtimes;
	}

	public Optional<Showtime> getShowtimeById(Integer showtimeId) {
		return showtimeRepository.findById(showtimeId);
	}
	
	public void addShowtime(Showtime showtime) {
		showtimeRepository.save(showtime);
	}
	
	public void updateShowtime(Showtime showtime) {
		showtimeRepository.save(showtime);
	}
	
	public void deleteShowtimeById(Integer showtimeId) {
		showtimeRepository.deleteById(showtimeId);
	}
	
}
