package com.kodlama.rentalService.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	private String id;
	
	private String carId;
	
	private int rentedForDays;
	
	private double dailyPrice;

	
}