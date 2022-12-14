package com.kodlamaio.inventoryservice.business.concrete;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.common.events.inventories.brand.BrandDeletedEvent;
import com.kodlamaio.common.events.inventories.brand.BrandUpdatedEvent;
import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.inventoryservice.business.abstracts.BrandService;
import com.kodlamaio.inventoryservice.business.requests.Create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.requests.Update.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.Create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.Get.GetBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.GetAll.GetAllBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.Update.UpdateBrandResponse;
import com.kodlamaio.inventoryservice.dataAccess.BrandRepository;
import com.kodlamaio.inventoryservice.entities.Brand;
import com.kodlamaio.inventoryservice.kafka.producer.inventories.InventoryProducer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private InventoryProducer inventoryProducer;

	@Override
	public List<GetAllBrandResponse> getAll() {
		List<Brand> brands =  this.brandRepository.findAll();
		
		List<GetAllBrandResponse> response = brands.stream()
				.map(brand->this.modelMapperService.forResponse()
				.map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
		
		return response;
	}
	
	
	@Override
	public GetBrandResponse getById(String id) {
		
		checkIfBrandExistsById(id);
		
		Brand brand = this.brandRepository.findById(id).get();
		
		GetBrandResponse response = this.modelMapperService.forResponse().map(brand, GetBrandResponse.class);
		
		return response;
	}

	
	
	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) { 
		
		checkIfBrandExistsByName(createBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest()
				.map(createBrandRequest, Brand.class);
		brand.setId(UUID.randomUUID().toString());
		
		this.brandRepository.save(brand);
		
		CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse()
				.map(brand, CreateBrandResponse.class);
		
		return createBrandResponse;
	}
	
	
	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {

		checkIfBrandExistsById(updateBrandRequest.getId());
		
		Brand brand = this.modelMapperService.forRequest()
				.map(updateBrandRequest, Brand.class);
		brand.setId(updateBrandRequest.getId());
		
		this.brandRepository.save(brand);
		
		UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse()
				.map(brand, UpdateBrandResponse.class);
		
		updateMongo(updateBrandRequest.getId(), brand.getName());
		
		return updateBrandResponse;
	}

	private void updateMongo(String id, String name) {
		
        BrandUpdatedEvent event = new BrandUpdatedEvent();
        
        event.setId(id);
        event.setName(name);
        
        inventoryProducer.sendMessage(event);
    }

	@Override
	public void delete(String id) {
		
		checkIfBrandExistsById(id);
		
		this.brandRepository.deleteById(id);
		
		deleteMongo(id);
	}
	
	private void deleteMongo(String id) {
		
        BrandDeletedEvent event = new BrandDeletedEvent();
        
        event.setBrandId(id);
        
        inventoryProducer.sendMessage(event);
    }
	
	// CONTROLS
	

	private void checkIfBrandExistsByName(String name) {
		
		if(brandRepository.existsByName(name)) {
			
		    throw new BusinessException("BRAND EXISTS");
		}
	}

	
	private void checkIfBrandExistsById(String id) {
		
		if (!this.brandRepository.existsById(id)) {
			
			throw new BusinessException("BRAND NOT EXISTS");
		}
	}
	

}
