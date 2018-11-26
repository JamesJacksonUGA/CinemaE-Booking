package cinema.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.Promotion;
import cinema.booking.models.User;
import cinema.booking.services.MailService;
import cinema.booking.services.PromotionService;
import cinema.booking.services.UserService;

@Controller
public class AddPromotionController {
	
	@Autowired
	PromotionService promotionService;
	@Autowired
	private MailService mailService;
	@Autowired
	private UserService userService;
	
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
	
	@PostMapping(value="/sendEmail")
	public String sendEmail(@RequestParam String subject,
			@RequestParam String message,
			Model model) {
		
		List<User> users = userService.findUsersWithPromo();
		for (int i = 0; i < users.size(); i++) {			
			try {
				mailService.sendSimpleMessage(users.get(i).getEmail(), subject, message);
			}
			catch (MailException e) {
				System.out.println("Could not send message");
				model.addAttribute("promotion", new Promotion());
				model.addAttribute("deletePromoCode", new String());
				return "addPromotion";
			}
		}
		
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("deletePromoCode", new String());
		return "addPromotion";
	}
	
}









