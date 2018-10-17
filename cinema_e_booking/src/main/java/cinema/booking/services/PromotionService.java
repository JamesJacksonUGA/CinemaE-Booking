package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Promotion;
import cinema.booking.repositories.PromotionRepository;

@Service
public class PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;
	
	
	public List<Promotion> getAllPromotions() {
		List<Promotion> promotions = new ArrayList<>();
		promotionRepository.findAll().forEach(promotions::add);
		return promotions;
	}

	public Optional<Promotion> getPromotionById(Integer promotionId) {
		return promotionRepository.findById(promotionId);
	}
	
	public void addPromotion(Promotion promotion) {
		promotionRepository.save(promotion);
	}
	
	public void updatePromotion(Promotion promotion) {
		promotionRepository.save(promotion);
	}
	
	public void deletePromotionById(Integer promotionId) {
		promotionRepository.deleteById(promotionId);
	}
	
}
