package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.User;
import cinema.booking.services.MailService;
import cinema.booking.services.UserService;

@Controller
public class ForgotPasswordController {

	@Value("${server.port}")
	String port;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@RequestMapping(value="/forgotPassword")
	public String forgotPassword() {
		return "forgotPassword";
	}
	
	@PostMapping(value="/forgotPassword")
	public String showPage(@ModelAttribute("email") String email, Model model) {
        
        //make sure email exists in the system
        if (userService.duplicateEmail(email) == true) {
        	
        	//send email to recover password
        	String subject = "Athens Tickets Password Reset";
    		String text = "In order to change your password, please click the link bellow: \n"
    				+ "\nhttp://localhost:" + port + "/forgotPassword/" + email;
    		
    		try {
    			mailService.sendSimpleMessage(email, subject, text);
    		}
    		catch (MailException e) {
    			System.out.println("Could not send message");
    			
    			model.addAttribute("failedToSend", "true");
    			return "forgotPassword";
    		}
        	
        	model.addAttribute("forgotPasswordEmail", "true");
        	return "homepage";
        }
        else {
        	model.addAttribute("email", "true");
        	return "forgotPassword";
        }
        
    }
	
	@RequestMapping(value="/forgotPassword/{email}")
	public String changePasswordPage(@PathVariable("email") String email, Model model) {
		model.addAttribute("email",  email);
		return "changePassword";
	}
	
	@PostMapping(value="/changePassword/{email}")
	public String changePassword(@PathVariable("email") String email, 
			@ModelAttribute("password") String password, Model model) {
		
		//get user associated with email address
		User user = userService.findUserByEmail(email);
		user.setPassword(encoder.encode(password));
		userService.updateUser(user);
		
		model.addAttribute("passwordChanged", "true");
		return "homepage";
	}
	
}






