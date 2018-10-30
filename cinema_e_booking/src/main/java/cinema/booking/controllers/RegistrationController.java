package cinema.booking.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import cinema.booking.models.User;
import cinema.booking.services.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/registration")
	public String registerationPage(Model model) {
		model.addAttribute("newUser", new User());
		return "registration";
	}
	
	@PostMapping(value="/registration")
	public String registerUser(@ModelAttribute User newUser) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format.format(newUser.getBirthDate());
		java.util.Date bDate = format.parse(formatted);
		java.sql.Date birthDate = new java.sql.Date(bDate.getTime()); 
		newUser.setBirthDate(birthDate);
		
		
		newUser.setRole("USER");
		userService.addUser(newUser);
		return "homepage";
	}

}
