package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class manageMoviesController {

	@RequestMapping(value="/manageMovies")
	public String manageMovies() {
		return "manageMovies";
	}
}
