package com.kodlamaio.inventoryservice.business.concrete;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.common.events.inventories.InventoryCreatedEvent;
import com.kodlamaio.common.events.inventories.car.CarDeletedEvent;
import com.kodlamaio.common.events.inventories.car.CarUpdatedEvent;
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
import com.kodlamaio.inventoryservice.kafka.producer.inventories.InventoryProducer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	private InventoryProducer inventoryProducer;
	
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
		
		addMongo(car.getId());
		
		return createCarResponse;
	
	}
	
	private void addMongo(String id) {
		
        Car car = carRepository.findById(id).get();
        
        InventoryCreatedEvent event = modelMapperService.forResponse().map(car, InventoryCreatedEvent.class);
        
        inventoryProducer.sendMessage(event);
    }
	
	
	@Override
	public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
		
		checkIfCarExistsById(updateCarRequest.getId());
		checkIfCarExistsByPlate(updateCarRequest.getPlate());
		
		Car car = this.modelMapperService.forRequest()
				.map(updateCarRequest, Car.class);
		car.setId(updateCarRequest.getId());
		
		this.carRepository.save(car);
		
		UpdateCarResponse updateCarResponse = this.modelMapperService.forResponse()
				.map(car, UpdateCarResponse.class);
		
		updateMongo(updateCarRequest, updateCarRequest.getId());
		
		return updateCarResponse;
	}

	private void updateMongo(UpdateCarRequest request, String id) {
		
        Car car = carRepository.findById(id).get();
        
        car.getModel().setId(request.getModelId());
        car.getModel().getBrand().setId(car.getModel().getBrand().getId());
        car.setState(request.getState());
        car.setPlate(request.getPlate());
        car.setModelYear(request.getModelYear());
        car.setDailyPrice(request.getDailyPrice());

        CarUpdatedEvent event = modelMapperService.forResponse().map(car, CarUpdatedEvent.class);
        
        inventoryProducer.sendMessage(event);
    }

	@Override
	public void delete(String id) {
		
		checkIfCarExistsById(id);
		
		this.carRepository.deleteById(id);
		
		deleteMongo(id);
	}
	
	private void deleteMongo(String id) {
		
	     CarDeletedEvent event = new CarDeletedEvent();
	     
	     event.setCarId(id);
	     
	     inventoryProducer.sendMessage(event);
	    }
	
	@Override
	public void updateCarState(int state) {
		
		 this.carRepository.findByState(state);
	}
	
	
	@Override
	public void checkIfCarAvailable(String id) {
		
		Car car = carRepository.findById(id).get();
		
        if (car.getState() != 3) {
        	
            throw new BusinessException("CAR NOT AVAILABLE");
        }
		
	}
	
	
	
	// CONTROLS
	
	
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
