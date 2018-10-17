package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Seat;

public interface SeatRepository extends CrudRepository<Seat, Integer> {

}
