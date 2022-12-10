package com.kodlama.paymentService.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payments")
public class Payment {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name_on_card")
	private String nameOnCard;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="card_expiration_month")
	private int cardExpirationMonth;
	
	@Column(name="card_expiration_year")
	private int cardExpirationYear;
	
	@Column(name="cvv")
	private String cvv;
	
	@Column(name = "balance")
    private double balance;
}
