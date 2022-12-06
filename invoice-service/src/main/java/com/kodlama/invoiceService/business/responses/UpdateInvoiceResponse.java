package com.kodlama.invoiceService.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceResponse {
	private String id;
	private String carId;
	private String nameOnCard;
	private String modelName;
	private int modelYear;
	private double dailyPrice;
	private double totalPrice;
	private int rentedForDays;
}
