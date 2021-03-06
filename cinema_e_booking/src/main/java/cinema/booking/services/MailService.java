package cinema.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
    public JavaMailSender javaMailSender;
	
	public void sendSimpleMessage(String to, String subject, String text) throws MailException{
		SimpleMailMessage message = new SimpleMailMessage(); 
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
	}
	
}
