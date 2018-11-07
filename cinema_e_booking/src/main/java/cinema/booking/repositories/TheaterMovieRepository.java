package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.TheaterMovie;

public interface TheaterMovieRepository extends CrudRepository<TheaterMovie, Integer> {

}
