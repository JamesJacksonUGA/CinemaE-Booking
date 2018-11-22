package cinema.booking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	@Query(value="SELECT COUNT(*) FROM ticket WHERE type=1 AND booking_booking_id= :bookingId", nativeQuery=true)
	Integer getAdultByBookingId(Integer bookingId);
	
	@Query(value="SELECT COUNT(*) FROM ticket WHERE type=2 AND booking_booking_id= :bookingId", nativeQuery=true)
	Integer getChildByBookingId(Integer bookingId);
	
	@Query(value="SELECT COUNT(*) FROM ticket WHERE type=3 AND booking_booking_id= :bookingId", nativeQuery=true)
	Integer getSeniorByBookingId(Integer bookingId);

	@Query(value="SELECT distinct(selling_price) FROM ticket WHERE type=1 AND booking_booking_id= :bookingId", nativeQuery=true)
	double getAdultSellingPrice(Integer bookingId);
	
	@Query(value="SELECT distinct(selling_price) FROM ticket WHERE type=2 AND booking_booking_id= :bookingId", nativeQuery=true)
	double getChildSellingPrice(Integer bookingId);
	
	@Query(value="SELECT distinct(selling_price) FROM ticket WHERE type=3 AND booking_booking_id= :bookingId", nativeQuery=true)
	double getSeniorSellingPrice(Integer bookingId);
	
}
