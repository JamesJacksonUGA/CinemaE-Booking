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

import cinema.booking.models.PaymentInfo;
import cinema.booking.services.PaymentInfoService;

@RestController
public class PaymentInfoController {

	@Autowired
	private PaymentInfoService paymentInfoService;
	
	
	@GetMapping("/paymentInfo")
	public List<PaymentInfo> getAllPaymentInfos() {
		return paymentInfoService.getAllPaymentInfos();
	}
	
	@GetMapping("/paymentInfo/{paymentInfoId}")
	public Optional<PaymentInfo> getPaymentInfoById(@PathVariable Integer paymentInfoId) {
		return paymentInfoService.getPaymentInfoById(paymentInfoId);
	}
	
	@PostMapping("/paymentInfo")
	public void addPaymentInfo(@RequestBody PaymentInfo paymentInfo) {
		paymentInfoService.addPaymentInfo(paymentInfo);
	}
	
	@PutMapping("/paymentInfo/{paymentInfoId}")
	public void updatePaymentInfo(@RequestBody PaymentInfo paymentInfo, @PathVariable Integer paymentInfoId) {
		paymentInfoService.updatePaymentInfo(paymentInfo);
	}
	
	@DeleteMapping("paymentInfo/{paymentInfoId}")
	public void deletePaymentInfoById(@PathVariable Integer paymentInfoId) {
		paymentInfoService.deletePaymentInfoById(paymentInfoId);
	}
	
}
