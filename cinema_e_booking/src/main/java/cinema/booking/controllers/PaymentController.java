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

import cinema.booking.models.Payment;
import cinema.booking.services.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	
	@GetMapping("/payment")
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}
	
	@GetMapping("/payment/{paymentId}")
	public Optional<Payment> getPaymentById(@PathVariable Integer paymentId) {
		return paymentService.getPaymentById(paymentId);
	}
	
	@PostMapping("/payment")
	public void addPayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
	}
	
	@PutMapping("/payment/{paymentId}")
	public void updatePayment(@RequestBody Payment payment, @PathVariable Integer paymentId) {
		paymentService.updatePayment(payment);
	}
	
	@DeleteMapping("payment/{paymentId}")
	public void deletePaymentById(@PathVariable Integer paymentId) {
		paymentService.deletePaymentById(paymentId);
	}
	
}
