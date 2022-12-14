package com.kodlamaio.common.events.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalUpdatedEvent {
	private String newCarId;
	private String oldCarId;
	private String message;
}
