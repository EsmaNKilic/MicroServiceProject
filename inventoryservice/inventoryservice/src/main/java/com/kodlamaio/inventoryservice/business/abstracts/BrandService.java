package com.kodlamaio.inventoryservice.business.abstracts;

import java.util.List;

import com.kodlamaio.inventoryservice.business.requests.Create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.requests.Update.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.Create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.Get.GetBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.GetAll.GetAllBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.Update.UpdateBrandResponse;

public interface BrandService {
	
	List<GetAllBrandResponse> getAll();
	GetBrandResponse getById(String id);
	CreateBrandResponse add(CreateBrandRequest createBrandRequest);
	UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);
	void delete(String id);
}
