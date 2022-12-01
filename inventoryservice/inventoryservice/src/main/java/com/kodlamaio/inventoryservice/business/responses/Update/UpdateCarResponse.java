package com.kodlamaio.inventoryservice.business.responses.Update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarResponse {
	private String id;
	private double dailyPrice;
	private int modelYear;
	private String plate;
	private int state;
	private String modelId;
}
