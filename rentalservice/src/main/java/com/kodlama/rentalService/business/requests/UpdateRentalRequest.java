package com.kodlama.rentalService.business.requests;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	private String id;
	
	private String carId;
	
	private LocalDateTime dateStarted;
	
	private int rentedForDays;
	
	private double dailyPrice;

	
}
