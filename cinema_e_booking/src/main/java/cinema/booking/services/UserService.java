package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.booking.models.User;
import cinema.booking.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public Optional<User> getUserById(Integer userId) {
		return userRepository.findById(userId);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
	}
	
	public String findCodeByUserId(Integer userId) {
		return userRepository.findCodeByUserId(userId);
	}
	
	@Transactional
	public void setEnabledByUserId(Integer userId) {
		userRepository.setEnabledByUserId(userId);
	}
	
	public Boolean duplicateEmail(String email) {
		return userRepository.findEmail(email) != null;
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
}
