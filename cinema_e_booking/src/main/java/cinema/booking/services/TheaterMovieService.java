package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.TheaterMovie;
import cinema.booking.repositories.TheaterMovieRepository;

@Service
public class TheaterMovieService {

	@Autowired
	private TheaterMovieRepository theaterMovieRepository;
	
	
	public List<TheaterMovie> getAllTheaterMovies() {
		List<TheaterMovie> theaterMovies = new ArrayList<>();
		theaterMovieRepository.findAll().forEach(theaterMovies::add);
		return theaterMovies;
	}

	public Optional<TheaterMovie> getTheaterMovieById(Integer theaterMovieId) {
		return theaterMovieRepository.findById(theaterMovieId);
	}
	
	public void addTheaterMovie(TheaterMovie theaterMovie) {
		theaterMovieRepository.save(theaterMovie);
	}
	
	public void updateTheaterMovie(TheaterMovie theaterMovie) {
		theaterMovieRepository.save(theaterMovie);
	}
	
	public void deleteTheaterMovieById(Integer theaterMovieId) {
		theaterMovieRepository.deleteById(theaterMovieId);
	}
	
}
