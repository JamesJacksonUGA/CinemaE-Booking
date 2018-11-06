package cinema.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.Showtime;

public interface ShowtimeRepository extends CrudRepository<Showtime, Integer> {
	
	@Query(value="SELECT * FROM showtime s where s.theater_theater_id = :theaterId AND s.movie_movie_id = :movieId", nativeQuery=true) 
	List<Showtime> findByTheaterIdMovieId(@Param("theaterId") Integer theaterId, @Param("movieId") Integer movieId);
	
}
