package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.Payment;
import com.virtusa.travelline.repositories.PaymentRepository;
@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> getAllpayment() {
		return paymentRepository.findAll();
	}

	public Payment getpaymentById(int paymentId) {
		return paymentRepository.findById(paymentId).orElse(null);
	}

	public Payment addpayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	public boolean deletepayment(int paymentId) {
		boolean status = false;
		paymentRepository.deleteById(paymentId);
		status = true;
		return status;
	}

	public Payment updatepayment(Payment payment) {
		return paymentRepository.save(payment);
	}
}