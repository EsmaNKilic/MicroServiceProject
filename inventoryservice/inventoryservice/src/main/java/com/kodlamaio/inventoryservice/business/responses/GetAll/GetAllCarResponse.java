package com.kodlamaio.inventoryservice.business.responses.GetAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarResponse {
	private String id;
	private double dailyPrice;
	private int modelYear;
	private String plate;
	private String modelName;
	private String brandName;
}
