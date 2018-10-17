package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
