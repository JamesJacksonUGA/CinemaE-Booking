package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Payment;
import cinema.booking.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	public List<Payment> getAllPayments() {
		List<Payment> payments = new ArrayList<>();
		paymentRepository.findAll().forEach(payments::add);
		return payments;
	}

	public Optional<Payment> getPaymentById(Integer paymentId) {
		return paymentRepository.findById(paymentId);
	}
	
	public void addPayment(Payment payment) {
		paymentRepository.save(payment);
	}
	
	public void updatePayment(Payment payment) {
		paymentRepository.save(payment);
	}
	
	public void deletePaymentById(Integer paymentId) {
		paymentRepository.deleteById(paymentId);
	}
}
