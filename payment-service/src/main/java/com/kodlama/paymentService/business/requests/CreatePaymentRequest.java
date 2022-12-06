package com.kodlama.paymentService.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {
	private String cardNumber;
	private String nameOnCard;
	private int cardExpirationMonth;
	private int cardExpirationYear;
	private String cvv;
	private double balance;
}
