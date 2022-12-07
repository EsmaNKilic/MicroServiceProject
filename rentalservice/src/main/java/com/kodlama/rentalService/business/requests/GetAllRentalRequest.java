package com.kodlama.rentalService.business.requests;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllRentalRequest {
	  	@NotBlank
	    @NotNull
	    private String carId;
	    @NotBlank
	    @NotNull
	    private LocalDateTime dateStarted;
	    @NotBlank
	    @NotNull
	    private int rentedForDays;
	    @NotBlank
	    @NotNull
	    private double dailyPrice;
	    @NotBlank
	    @NotNull
	    private double totalPrice;
}
