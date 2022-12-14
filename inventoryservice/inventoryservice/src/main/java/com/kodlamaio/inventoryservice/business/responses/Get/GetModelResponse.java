package com.kodlamaio.inventoryservice.business.responses.Get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelResponse {
	private String id;
	private String name;
	private String brandId;
	private String brandName;
}
