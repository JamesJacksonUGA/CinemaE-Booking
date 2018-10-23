package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
