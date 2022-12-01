package com.kodlamaio.inventoryservice.business.concrete;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryservice.business.abstracts.CarService;
import com.kodlamaio.inventoryservice.business.requests.Create.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.requests.Update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.responses.Create.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.responses.Get.GetCarResponse;
import com.kodlamaio.inventoryservice.business.responses.GetAll.GetAllCarResponse;
import com.kodlamaio.inventoryservice.business.responses.Update.UpdateCarResponse;
import com.kodlamaio.inventoryservice.dataAccess.CarRepository;
import com.kodlamaio.inventoryservice.entities.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class CarManager implements CarService {

	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCarResponse> getAll() {
		List<Car> cars =  this.carRepository.findAll();
		
		List<GetAllCarResponse> response = cars.stream()
				.map(car->this.modelMapperService.forResponse()
				.map(car, GetAllCarResponse.class)).collect(Collectors.toList());
		
		return response;
	}
	
	
	@Override
	public GetCarResponse getById(String id) {
		
		checkIfCarExistsById(id);
		
		Car car = this.carRepository.findById(id).get();
		
		GetCarResponse response = this.modelMapperService.forResponse().map(car, GetCarResponse.class);
		
		return response;
	}


	
	@Override
	public CreateCarResponse add(CreateCarRequest createCarRequest) {
		
		checkIfCarExistsByPlate(createCarRequest.getPlate());
		
		Car car = this.modelMapperService.forRequest()
				.map(createCarRequest, Car.class);
		car.setId(UUID.randomUUID().toString());
		
		this.carRepository.save(car);
		
		CreateCarResponse createCarResponse = this.modelMapperService.forResponse()
				.map(car, CreateCarResponse.class);
		
		return createCarResponse;
	}
	
	
	@Override
	public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
		
		checkIfCarExistsById(updateCarRequest.getId());
		
		Car car = this.modelMapperService.forRequest()
				.map(updateCarRequest, Car.class);
		car.setId(updateCarRequest.getId());
		
		this.carRepository.save(car);
		
		UpdateCarResponse updateCarResponse = this.modelMapperService.forResponse()
				.map(car, UpdateCarResponse.class);
		
		return updateCarResponse;
	}


	@Override
	public void delete(String id) {
		
		checkIfCarExistsById(id);
		
		this.carRepository.deleteById(id);
	}
	
	
	// RULES
	
	
	private void checkIfCarExistsByPlate(String plate) {
		
		if(carRepository.existsByPlate(plate)) {
			
		    throw new BusinessException("CAR EXISTS");
		}
	}

	
	private void checkIfCarExistsById(String id) {
		
		if (!this.carRepository.existsById(id)) {
			
			throw new BusinessException("CAR NOT EXISTS");
		
		}
	}
	
	
	

}
