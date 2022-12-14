package com.kodlamaio.inventoryservice.business.abstracts;

import java.util.List;

import com.kodlamaio.inventoryservice.business.requests.Create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.requests.Update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.responses.Create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.responses.Get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.responses.GetAll.GetAllModelResponse;
import com.kodlamaio.inventoryservice.business.responses.Update.UpdateModelResponse;

public interface ModelService {
	
	List<GetAllModelResponse> getAll();
	GetModelResponse getById(String id);
	CreateModelResponse add(CreateModelRequest createModelRequest);
	UpdateModelResponse update(UpdateModelRequest updateModelRequest);
	void delete(String id);

}
