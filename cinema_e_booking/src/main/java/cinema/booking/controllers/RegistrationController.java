package cinema.booking.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.User;
import cinema.booking.services.MailService;
import cinema.booking.services.UserService;

@Controller
public class RegistrationController {
		
	@Value("${server.port}")
	String port;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping(value="/registration")
	public String registrationPage(Model model) {
		model.addAttribute("newUser", new User());
		return "registration";
	}
	
	@PostMapping(value="/registration")
	public String registerUser(@ModelAttribute User newUser, Model model) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format.format(newUser.getBirthDate());
		java.util.Date bDate = format.parse(formatted);
		java.sql.Date birthDate = new java.sql.Date(bDate.getTime()); 
		newUser.setBirthDate(birthDate);
		
		newUser.setRole("USER");
		newUser.setEnabled(false);
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		
		String code = Long.toHexString(Double.doubleToLongBits(Math.random()));
		newUser.setCode(code);
		userService.addUser(newUser);
		
		String subject = "Athens Tickets Account Verification";
		String text = "In order to validate your account, please click the link and enter the following code: \n" + code
				+ "\nhttp://localhost:" + port + "/registrationConfirmation/" + newUser.getUserId();
		
		try {
			mailService.sendSimpleMessage(newUser.getEmail(), subject, text);
		}
		catch (MailException e) {
			System.out.println("Could not send message");
		}
		
		model.addAttribute("newUser", newUser);
		model.addAttribute("registered", "true");
		return "/homepage";
	}
	
	@GetMapping(value="/registrationConfirmation/{userId}")
	public String registrationConfirmation(@PathVariable Integer userId,  Model model) {
		model.addAttribute("userId", userId);
		return "registrationConfirmation";
	}
	
	@GetMapping(value="/activate/{userId}")
	public String activate(@PathVariable Integer userId, @RequestParam("code") String code, Model model) {
		
		String userCode = userService.findCodeByUserId(userId);
		
		if (userCode.equals(code)) {
			model.addAttribute("activated", "true");
			userService.setEnabledByUserId(userId);
			return "homepage";
		}
		else {
			model.addAttribute("error", "true");
			return "/registrationConfirmation";
		}
	}

}




