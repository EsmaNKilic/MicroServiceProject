package com.kodlama.filterService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarFilter {

	@Id
	private String id;
	
	private String carId;

	private double carDailyPrice;

	private int carModelYear;

	private String carPlate;

	private String carModelId;

	private String carModelName;

	private String carBrandId;

	private String carBrandName;
	
	private String carState;
}
