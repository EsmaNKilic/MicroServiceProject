package com.kodlama.invoiceService.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
	private String carId;
	private String nameOnCard;
	private String modelName;
	private int modelYear;
	private double dailyPrice;
	private double totalPrice;
	private int rentedForDays;
}
