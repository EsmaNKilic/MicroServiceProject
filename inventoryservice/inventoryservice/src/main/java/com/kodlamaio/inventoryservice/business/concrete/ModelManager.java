package com.kodlamaio.inventoryservice.business.concrete;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.common.events.inventories.model.ModelDeletedEvent;
import com.kodlamaio.common.events.inventories.model.ModelUpdatedEvent;
import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.requests.Create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.requests.Update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.responses.Create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.responses.Get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.responses.GetAll.GetAllModelResponse;
import com.kodlamaio.inventoryservice.business.responses.Update.UpdateModelResponse;
import com.kodlamaio.inventoryservice.dataAccess.ModelRepository;
import com.kodlamaio.inventoryservice.entities.Model;
import com.kodlamaio.inventoryservice.kafka.producer.inventories.InventoryProducer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private InventoryProducer inventoryProducer;
	
	@Override
	public List<GetAllModelResponse> getAll() {
		
		List<Model> models =  this.modelRepository.findAll();
		
		List<GetAllModelResponse> response = models.stream()
				.map(model->this.modelMapperService.forResponse()
				.map(model, GetAllModelResponse.class)).collect(Collectors.toList());
		
		return response;
	}
	
	
	@Override
	public GetModelResponse getById(String id) {
		
		checkIfModelExistsById(id);
		
		Model model = this.modelRepository.findById(id).get();
		
		GetModelResponse response = this.modelMapperService.forResponse().map(model, GetModelResponse.class);
		
		return response;
	}
	

	@Override
	public CreateModelResponse add(CreateModelRequest createModelRequest) {
		
		checkIfModelExistsByName(createModelRequest.getName());
		
		Model model = this.modelMapperService.forRequest()
				.map(createModelRequest, Model.class);
		model.setId(UUID.randomUUID().toString());
		
		this.modelRepository.save(model);
		
		CreateModelResponse createModelResponse = this.modelMapperService.forResponse()
				.map(model, CreateModelResponse.class);
		
		return createModelResponse;
	}
	
	
	@Override
	public UpdateModelResponse update(UpdateModelRequest updateModelRequest) {
		
		checkIfModelExistsById(updateModelRequest.getId());
		
		Model model = this.modelMapperService.forRequest()
				.map(updateModelRequest, Model.class);
		model.setId(updateModelRequest.getId());
		
		this.modelRepository.save(model);
		
		UpdateModelResponse updateModelResponse = this.modelMapperService.forResponse()
				.map(model, UpdateModelResponse.class);
		
		updateMongo(updateModelRequest.getId(), updateModelRequest.getName(), updateModelRequest.getBrandId());
		
		return updateModelResponse;
	}

	private void updateMongo(String id, String name, String brandId) {
		
        ModelUpdatedEvent event = new ModelUpdatedEvent();
        
        event.setId(id);
        event.setName(name);
        event.setBrandId(brandId);
        
        inventoryProducer.sendMessage(event);
    }

	@Override
	public void delete(String id) {
		
		checkIfModelExistsById(id);
		
		this.modelRepository.deleteById(id);
		
		deleteMongo(id);
		
	}
	
	private void deleteMongo(String id) {
		
        ModelDeletedEvent event = new ModelDeletedEvent();
        
        event.setModelId(id);
        inventoryProducer.sendMessage(event);
    }
	
	
	// CONTROLS
	
	
	private void checkIfModelExistsByName(String name) {
		
		if(modelRepository.existsByName(name)) {
			
		    throw new BusinessException("MODEL EXISTS");
		}
	}
	
	
	
	private void checkIfModelExistsById(String id) {
		
		if (!this.modelRepository.existsById(id)) {
			
			throw new BusinessException("MODEL NOT EXISTS");
	}
		
	}

}
