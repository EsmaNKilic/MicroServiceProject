package com.kodlama.rentalService.business.requests;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllRentalRequest {
	    private String carId;
	    private LocalDateTime dateStarted;
	    private int rentedForDays;
	    private double dailyPrice;
	    private double totalPrice;
}
