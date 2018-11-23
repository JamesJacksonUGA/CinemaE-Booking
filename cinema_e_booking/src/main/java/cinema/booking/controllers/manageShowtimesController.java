package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class manageShowtimesController {

	@RequestMapping(value="/manageShowtimes")
	public String login() {
		return "manageShowtimes";
	}

}
