package com.kodlama.rentalService.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {
	  private String cardNumber; 
	  private String nameOnCard;
	  private int cardExpirationYear;   
	  private int cardExpirationMonth;
	  private String cvv;
}
