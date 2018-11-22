package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.Promotion;
import cinema.booking.services.PromotionService;

@Controller
public class AddPromotionController {
	
	@Autowired
	PromotionService promotionService;
	
	@RequestMapping(value="/addPromotion")
	public String addPromotion(Model model) {
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("deletePromoCode", new String());
		return "addPromotion";
	}
	
	@PostMapping(value="/addPromotion")
	public String postPromotion(@ModelAttribute("promotion") Promotion promotion, Model model) {
		
		if (promotionService.getPromotionByPromoCode(promotion.getPromoCode()) != null) {
			model.addAttribute("duplicate", "true");
			model.addAttribute("promotion", new Promotion());
			model.addAttribute("deletePromoCode", new String());
			return "addPromotion";
		}
		
		promotionService.addPromotion(promotion);
		
		model.addAttribute("added", "true");
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("deletePromoCode", new String());
		return "addPromotion";
	}
	
	@PostMapping(value="/deletePromotion")
	public String deletePromotion(@RequestParam String deletePromoCode, Model model) {
		
		Promotion promo = promotionService.getPromotionByPromoCode(deletePromoCode);
		if (promo != null) {
			promotionService.deletePromotionById(promo.getPromotionId());
			model.addAttribute("promotion", new Promotion());
			model.addAttribute("deletePromoCode", new String());
			model.addAttribute("deleted", "true");
			return "addPromotion";
		}
		else {
			model.addAttribute("wrongCode", "true");
			model.addAttribute("promotion", new Promotion());
			model.addAttribute("deletePromoCode", new String());
			return "addPromotion";
		}
		
	}
	
}









