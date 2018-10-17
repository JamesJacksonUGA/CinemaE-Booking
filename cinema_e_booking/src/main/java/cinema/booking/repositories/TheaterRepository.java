package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Theater;

public interface TheaterRepository extends CrudRepository<Theater, Integer> {

}
