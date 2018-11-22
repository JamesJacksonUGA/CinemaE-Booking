package cinema.booking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.PaymentInfo;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Integer> {

	@Query(value="SELECT * FROM payment_info p where p.payment_info_id = :paymentInfoId", nativeQuery=true)
	PaymentInfo findPaymentInfoById(@Param("paymentInfoId") Integer paymentInfoId);

}
