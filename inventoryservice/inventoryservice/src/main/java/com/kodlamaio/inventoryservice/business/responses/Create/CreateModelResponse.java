package com.kodlamaio.inventoryservice.business.responses.Create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelResponse {
	private String id;
	private String name;
	private String brandId;
	
}
