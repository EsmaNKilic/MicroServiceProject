package com.kodlamaio.inventoryservice.business.responses.Get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {
	private String id;
	private double dailyPrice;
	private int modelYear;
	private String plate;
	private int state;
	private String modelName;
	private String brandName;
}
