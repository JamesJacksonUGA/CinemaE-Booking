package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Promotion;

public interface PromotionRepository extends CrudRepository<Promotion, Integer> {

	Promotion findPromotionByPromoCode(String code);

}
