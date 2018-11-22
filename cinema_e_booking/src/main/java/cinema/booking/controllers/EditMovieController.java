package cinema.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditMovieController 
{
	@RequestMapping(value="/editMovie")
	public String userProfile() {
		return "editMovie";
	}
}