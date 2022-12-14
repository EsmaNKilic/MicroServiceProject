package com.kodlamaio.inventoryservice.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.inventoryservice.business.abstracts.BrandService;
import com.kodlamaio.inventoryservice.business.requests.Create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.requests.Update.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.responses.Create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.Get.GetBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.GetAll.GetAllBrandResponse;
import com.kodlamaio.inventoryservice.business.responses.Update.UpdateBrandResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController 
@RequestMapping("/api/brands")
public class BrandsController {
	
	private BrandService brandService;

	@GetMapping()
	public List<GetAllBrandResponse> getAll(){
		return this.brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetBrandResponse getById(@PathVariable String id) {
		return this.brandService.getById(id);
	}
	
	@PostMapping
	public CreateBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}
	
	@PutMapping
	public UpdateBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
		return this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.brandService.delete(id);
	}
}
