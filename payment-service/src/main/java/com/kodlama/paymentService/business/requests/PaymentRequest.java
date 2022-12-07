package com.kodlama.paymentService.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
	private String cardNumber;
	private String nameOnCard;
	private int cardExpirationMonth;
	private int cardExpirationYear;
	private String cvv;
	private double price;
}
