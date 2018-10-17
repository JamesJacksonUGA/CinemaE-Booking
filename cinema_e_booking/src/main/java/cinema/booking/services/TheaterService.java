package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public Optional<Theater> getTheaterById(Integer theaterId) {
		return theaterRepository.findById(theaterId);
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
}
