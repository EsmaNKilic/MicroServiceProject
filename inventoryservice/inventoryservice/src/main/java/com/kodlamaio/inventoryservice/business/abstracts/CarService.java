package com.kodlamaio.inventoryservice.business.abstracts;

import java.util.List;

import com.kodlamaio.inventoryservice.business.requests.Create.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.requests.Update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.responses.Create.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.responses.Get.GetCarResponse;
import com.kodlamaio.inventoryservice.business.responses.GetAll.GetAllCarResponse;
import com.kodlamaio.inventoryservice.business.responses.Update.UpdateCarResponse;

public interface CarService {

	List<GetAllCarResponse> getAll();
	GetCarResponse getById(String id);
	CreateCarResponse add(CreateCarRequest createCarRequest);
	UpdateCarResponse update(UpdateCarRequest updateCarRequest);
	void delete(String id);
	
	void updateCarState(int state);
	void checkIfCarAvailable(String id);

}
