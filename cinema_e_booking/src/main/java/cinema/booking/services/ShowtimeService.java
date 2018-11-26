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
	
	public Showtime findShowtimeById(Integer showtimeId) {
		return showtimeRepository.findShowtimeByShowtimeId(showtimeId);
	}
	
	public Integer findTheaterIdByShowtimeId(Integer showtimeId) {
		return showtimeRepository.findTheaterHallByShowtimeId(showtimeId);
	}
	
	public List<Showtime> findShowtimeByDate(String date, Integer movieId) {
		return showtimeRepository.findShowtimeByDate(date, movieId);
	}
	
	public Showtime findShowtimeByDateTheaterId(String date, Integer theaterId) {
		return showtimeRepository.findShowtimeByDateTheaterId(date, theaterId);
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
	
	public List<Showtime> getShowtimeByMovieId(Integer movieId) {
		return showtimeRepository.findByMovieMovieId(movieId);
	}
	
}
