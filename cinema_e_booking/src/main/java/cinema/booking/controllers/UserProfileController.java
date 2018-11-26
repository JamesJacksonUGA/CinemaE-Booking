package cinema.booking.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.User;
import cinema.booking.services.UserService;

@Controller
public class UserProfileController 
{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userProfile")
	public String userProfile(Model model) {
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		model.addAttribute("birthDate", user.getBirthDate().toString());
		
		return "userProfile";
	}
	
	@PostMapping(value="/basicInfo")
	public String basicInfo(@RequestParam String firstName, 
			@RequestParam String lastName, 
			@RequestParam String phone,
			Model model) {
		
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		
		//update users basic info
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhone(phone);
		userService.updateUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("birthDate", user.getBirthDate().toString());
		model.addAttribute("updated", "true");
		
		return "userProfile";
	}
	
	@PostMapping(value="/passwordChange")
	public String passwordChange(@RequestParam String pass, Model model) {

		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		
		
		
		model.addAttribute("user", user);
		model.addAttribute("birthDate", user.getBirthDate().toString());
		model.addAttribute("updated", "true");
		
		return "userProfile";
	}
	
}





