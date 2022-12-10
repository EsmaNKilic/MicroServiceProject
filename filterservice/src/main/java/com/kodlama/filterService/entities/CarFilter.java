package com.kodlama.filterService.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "inventoryfilter")
public class CarFilter {

	@Id
	private String id;
	
	@Field(name="car_id")
	private String carId;

	@Field(name="car_daily_price")
	private double carDailyPrice;

	@Field(name="car_model_year")
	private int carModelYear;

	@Field(name="car_plate")
	private String carPlate;

	@Field(name="car_model_id")
	private String carModelId;

	@Field(name="car_model_name")
	private String carModelName;

	@Field(name="car_brand_id")
	private String carBrandId;

	@Field(name="car_brand_name")
	private String carBrandName;
	
	@Field(name="car_state")
	private int carState;
}
