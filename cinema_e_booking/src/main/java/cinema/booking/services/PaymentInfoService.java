package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.PaymentInfo;
import cinema.booking.repositories.PaymentInfoRepository;

@Service
public class PaymentInfoService {

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	
	public List<PaymentInfo> getAllPaymentInfos() {
		List<PaymentInfo> paymentInfos = new ArrayList<>();
		paymentInfoRepository.findAll().forEach(paymentInfos::add);
		return paymentInfos;
	}

	public Optional<PaymentInfo> getPaymentInfoById(Integer paymentInfoId) {
		return paymentInfoRepository.findById(paymentInfoId);
	}
	
	public void addPaymentInfo(PaymentInfo paymentInfo) {
		paymentInfoRepository.save(paymentInfo);
	}
	
	public void updatePaymentInfo(PaymentInfo paymentInfo) {
		paymentInfoRepository.save(paymentInfo);
	}
	
	public void deletePaymentInfoById(Integer paymentInfoId) {
		paymentInfoRepository.deleteById(paymentInfoId);
	}
	
}
