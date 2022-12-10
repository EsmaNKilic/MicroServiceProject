package com.kodlama.paymentService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.paymentService.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String>{
	
	Payment findByCardNumber(String cardNumber);
	boolean existsByCardNumber(String cardNumber);
	boolean existsByAllInformation(
			String nameOnCard, 
			String cardNumber, 
			int cardExpirationYear, 
			int cardExpirationMonth, 
			String cvv);
	
}
