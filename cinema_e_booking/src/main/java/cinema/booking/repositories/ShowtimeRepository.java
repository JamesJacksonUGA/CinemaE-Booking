package cinema.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.Showtime;

public interface ShowtimeRepository extends CrudRepository<Showtime, Integer> {
	
	@Query(value="SELECT * FROM showtime s where s.theater_hall_number = :theaterId AND s.movie_movie_id = :movieId", nativeQuery=true) 
	List<Showtime> findByTheaterIdMovieId(@Param("theaterId") Integer theaterId, @Param("movieId") Integer movieId);

	List<Showtime> findByMovieMovieId(Integer movieId);

	Showtime findShowtimeByShowtimeId(Integer showtimeId);

	@Query(value="SELECT theater_theater_id FROM showtime s where s.showtime_id = :showtimeId", nativeQuery=true) 
	Integer findTheaterIdByShowtimeId(@Param("showtimeId") Integer showtimeId);

	@Query(value="SELECT * FROM showtime WHERE CAST(date_time as DATE) = :date AND movie_movie_id= :movieId", nativeQuery=true)
	List<Showtime> findShowtimeByDate(String date, Integer movieId);

	@Query(value="SELECT * FROM showtime WHERE CAST(date_time as DATE) = :date AND theater_hall_number= :theaterId", nativeQuery=true)
	List<Showtime> findShowtimeByDateTheaterId(String date, Integer theaterId);

	@Query(value="SELECT theater_hall_number FROM showtime WHERE showtime_id = :showtimeId", nativeQuery=true)
	Integer findTheaterHallByShowtimeId(Integer showtimeId);
	
}
