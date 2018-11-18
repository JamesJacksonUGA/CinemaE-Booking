package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addPromotionController {
	
	@RequestMapping(value="/addPromotion")
	public String addPromotion() {
		return "addPromotion";
	}
}
