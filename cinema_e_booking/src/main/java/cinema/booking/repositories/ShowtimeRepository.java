package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Showtime;

public interface ShowtimeRepository extends CrudRepository<Showtime, Integer> {

}
