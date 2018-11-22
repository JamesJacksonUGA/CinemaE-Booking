package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.Promotion;
import cinema.booking.services.PromotionService;

@Controller
public class AddPromotionController {
	
	@Autowired
	PromotionService promotionService;
	
	@RequestMapping(value="/addPromotion")
	public String addPromotion(Model model) {
		model.addAttribute("promotion", new Promotion());
		return "addPromotion";
	}
	
	@PostMapping(value="/addPromotion")
	public String postPromotion(@ModelAttribute("promotion") Promotion promotion, Model model) {
		
		promotionService.addPromotion(promotion);
		
		model.addAttribute("added", "true");
		model.addAttribute("promotion", new Promotion());
		return "addPromotion";
	}
}



