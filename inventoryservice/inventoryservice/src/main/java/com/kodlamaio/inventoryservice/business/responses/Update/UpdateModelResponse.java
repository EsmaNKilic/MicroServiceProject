package com.kodlamaio.inventoryservice.business.responses.Update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelResponse {
	private String id;
	private String name;
	private String brandId;
}
