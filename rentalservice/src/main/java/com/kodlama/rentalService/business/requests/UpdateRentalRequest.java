package com.kodlama.rentalService.business.requests;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	@NotNull
	@NotBlank
	private String id;
	@NotNull
    private String carId;
    @NotNull
    private LocalDateTime dateStarted;
    @NotNull
    private int rentedForDays;
    @NotNull
    @Min(0)
    private double dailyPrice;
	
}
