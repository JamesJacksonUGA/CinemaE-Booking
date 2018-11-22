package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecentPurchasesController {

	@RequestMapping(value="/recentPurchases")
	public String recentPurchases() {
		return "recentPurchases";
	}

}
