package cinema.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.User;
import cinema.booking.services.UserService;

@Controller
public class ManageUsersController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/manageUsers")
	public String manageUsers(Model model) {
		List<User> users =userService.getAllUsers();
		model.addAttribute("users", users);
		return "manageUsers";
	}
	
	@RequestMapping(value="/manageUsers/{userId}")
	public String manageUsers(@PathVariable("userId") Integer userId, Model model) {
		
		model.addAttribute("user", userService.findUserById(userId));
		
		return "userProfile";
	}
	
	@RequestMapping(value="/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId, Model model) {
		
		userService.deleteUserById(userId);
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("deleted", "true");
		return "manageUsers";
	}
	
	@RequestMapping(value="/suspendUser/{userId}")
	public String suspendUser(@PathVariable("userId") Integer userId, Model model) {
		
		User user = userService.findUserById(userId);
		user.setEnabled(false);
		userService.updateUser(user);
		
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("suspended", "true");
		return "manageUsers";
	}
	
	@RequestMapping(value="/activateUser/{userId}")
	public String activateUser(@PathVariable("userId") Integer userId, Model model) {
		
		User user = userService.findUserById(userId);
		user.setEnabled(true);
		userService.updateUser(user);
		
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("activated", "true");
		return "manageUsers";
	}
	
}





