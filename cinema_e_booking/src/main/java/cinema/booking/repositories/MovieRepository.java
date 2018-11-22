package cinema.booking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

	@Query(value="SELECT * FROM movie m WHERE m.movie_id = :movieId", nativeQuery=true)
	Movie findMovieById(@Param("movieId") Integer movieId);

}
