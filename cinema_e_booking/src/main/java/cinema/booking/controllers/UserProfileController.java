package cinema.booking.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserProfileController 
{
	@RequestMapping(value="/userProfile")
	public String userProfile() {
		return "userProfile";
	}
}