package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class selectTicketsController {

	@RequestMapping(value="/selectTickets")
	public String login() {
		return "selectTickets";
	}

}