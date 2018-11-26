package cinema.booking.controllers;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	@Autowired
	private PasswordEncoder encoder;
	
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
	public String passwordChange(@RequestParam("newPassword") String newPassword, 
			@RequestParam("confPassword") String confPassword, 
			Model model) {

		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		
		if (!newPassword.equals(confPassword)) {
			model.addAttribute("noMatch", "true");
			model.addAttribute("user", user);
			model.addAttribute("birthDate", user.getBirthDate().toString());
			return "userProfile";
		}
		
		user.setPassword(encoder.encode(newPassword));
		userService.updateUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("birthDate", user.getBirthDate().toString());
		model.addAttribute("updated", "true");
		
		return "userProfile";
	}
	
	@PostMapping(value="/emailChange")
	public String emailChange(@RequestParam("newEmail") String newEmail, 
			@RequestParam("confEmail") String confEmail,
			HttpServletRequest request, 
			HttpServletResponse response,
			Model model) {

		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findUserByEmail(userEmail);
		
		if (!newEmail.equals(confEmail)) {
			model.addAttribute("noMatchEmail", "true");
			model.addAttribute("user", user);
			model.addAttribute("birthDate", user.getBirthDate().toString());
			return "userProfile";
		}
		
		//determine if account already exists with this email
		if (userService.findUserByEmail(newEmail) != null) {
			model.addAttribute("duplicate", "true");
			return "userProfile";
		}
		
		user.setEmail(newEmail);
		userService.updateUser(user);
		
		user = userService.findUserByEmail(newEmail);
		model.addAttribute("user", user);
		model.addAttribute("birthDate", user.getBirthDate().toString());
		model.addAttribute("updated", "true");
		
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "homepage";
	}
	
}





