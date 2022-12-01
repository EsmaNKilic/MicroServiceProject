package com.kodlamaio.inventoryservice.business.responses.GetAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllModelResponse {
	private String id;
	private String name;
	private String brandId;
	private String brandName;
}
