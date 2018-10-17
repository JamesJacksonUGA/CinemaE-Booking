package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value= {"/", "/home"})
	public String index(Model model) {
		return "homepage";
	}
	
}
