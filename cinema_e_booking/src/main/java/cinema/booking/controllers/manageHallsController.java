package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class manageHallsController {

	@RequestMapping(value="/manageHalls")
	public String manageHalls() {
		return "manageHalls";
	}

}