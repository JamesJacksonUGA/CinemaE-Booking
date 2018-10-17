package cinema.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.booking.models.Promotion;
import cinema.booking.services.PromotionService;

@RestController
public class PromotionController {

	@Autowired
	private PromotionService promotionService;
	
	
	@GetMapping("/promotion")
	public List<Promotion> getAllPromotions() {
		return promotionService.getAllPromotions();
	}
	
	@GetMapping("/promotion/{promotionId}")
	public Optional<Promotion> getPromotionById(@PathVariable Integer promotionId) {
		return promotionService.getPromotionById(promotionId);
	}
	
	@PostMapping("/promotion")
	public void addPromotion(@RequestBody Promotion promotion) {
		promotionService.addPromotion(promotion);
	}
	
	@PutMapping("/promotion/{promotionId}")
	public void updatePromotion(@RequestBody Promotion promotion, @PathVariable Integer promotionId) {
		promotionService.updatePromotion(promotion);
	}
	
	@DeleteMapping("promotion/{promotionId}")
	public void deletePromotionById(@PathVariable Integer promotionId) {
		promotionService.deletePromotionById(promotionId);
	}
	
}
