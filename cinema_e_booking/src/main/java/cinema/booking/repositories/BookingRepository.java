package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
