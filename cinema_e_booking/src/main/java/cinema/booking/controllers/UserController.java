package cinema.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.booking.models.User;
import cinema.booking.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{userId}")
	public Optional<User> getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/user/{userId}")
	public void updateUser(@RequestBody User user, @PathVariable Integer userId) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("user/{userId}")
	public void deleteUserById(@PathVariable Integer userId) {
		userService.deleteUserById(userId);
	}
	
}
