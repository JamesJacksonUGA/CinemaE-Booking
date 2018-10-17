package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
