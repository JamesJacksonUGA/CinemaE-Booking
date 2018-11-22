package cinema.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

	@Query(value="SELECT * FROM booking b where b.user_user_id = :userId", nativeQuery=true) 
	List<Booking> findBookingsByUserId(@Param("userId") Integer userId);

	@Query(value="SELECT showtime_showtime_id FROM booking b where b.booking_id = :bookingId", nativeQuery=true)
	Integer findShowtimeIdByBookingId(@Param("bookingId") Integer bookingId);

	@Query(value="SELECT payment_info_payment_info_id FROM booking b where b.booking_id = :bookingId", nativeQuery=true)
	Integer findPaymentInfoIdByBookingId(@Param("bookingId") Integer bookingId);

}
