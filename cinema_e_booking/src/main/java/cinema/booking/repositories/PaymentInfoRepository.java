package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.PaymentInfo;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Integer> {

}
