package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Theater;
import cinema.booking.repositories.TheaterRepository;

@Service
public class TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;
	
	
	public List<Theater> getAllTheaters() {
		List<Theater> theaters = new ArrayList<>();
		theaterRepository.findAll().forEach(theaters::add);
		return theaters;
	}

	public Theater getTheaterByHallNumber(Integer hallNumber) {
		return theaterRepository.findByHallNumber(hallNumber);
	}
	
	public void addTheater(Theater theater) {
		theaterRepository.save(theater);
	}
	
	public void updateTheater(Theater theater) {
		theaterRepository.save(theater);
	}
	
	public void deleteTheaterById(Integer theaterId) {
		theaterRepository.deleteById(theaterId);
	}
	
	public void deleteTheaterByHallNumber(Integer hallNumber) {
		theaterRepository.deleteByHallNumber(hallNumber);
	}
}
