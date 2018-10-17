package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
