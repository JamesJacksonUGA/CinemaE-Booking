package cinema.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.Seat;

public interface SeatRepository extends CrudRepository<Seat, Integer> {

	@Query(value="SELECT * FROM seat s WHERE s.seat_no = :seatNo AND s.showtime_showtime_id = :showtimeId", nativeQuery=true)
	Seat findBySeatNoShowtimeId(@Param("seatNo") String seatNo, @Param("showtimeId") Integer showtimeId);

	@Query(value="SELECT * FROM seat s WHERE s.showtime_showtime_id = :showtimeId", nativeQuery=true)
	List<Seat> getSeatsByShowtimeId(Integer showtimeId);

}
