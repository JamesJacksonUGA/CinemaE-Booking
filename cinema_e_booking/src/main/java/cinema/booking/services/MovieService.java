package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Movie;
import cinema.booking.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movies::add);
		return movies;
	}

	public Optional<Movie> getMovieById(Integer movieId) {
		return movieRepository.findById(movieId);
	}
	
	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void deleteMovieById(Integer movieId) {
		movieRepository.deleteById(movieId);
	}
	
}
