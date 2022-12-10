package com.kodlama.filterService.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.filterService.business.abstracts.CarFilterService;
import com.kodlama.filterService.business.responses.GetAllFilterResponse;
import com.kodlama.filterService.dataAccess.CarFilterRepository;
import com.kodlama.filterService.entities.CarFilter;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarFilterManager implements CarFilterService{

	 private  CarFilterRepository carFilterRepository;
	 private  ModelMapperService modelMapperService;

	    @Override
	    public List<GetAllFilterResponse> getAll() {
	    	
	        List<CarFilter> filters = carFilterRepository.findAll();
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(carFilter -> modelMapperService.forResponse()
	                .map(carFilter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> getByCarBrandName(String carBrandName) {
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarBrandNameIgnoreCase(carBrandName);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(carFilter -> modelMapperService.forResponse()
	                .map(carFilter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> getByCarModelName(String carModelName) {
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarModelNameIgnoreCase(carModelName);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(carFilter -> modelMapperService.forResponse()
	                .map(carFilter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> getByCarPlate(String carPlate) {
	    	
	    	checkIfExistByPlate(carPlate);
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarPlateIgnoreCase(carPlate);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(filter -> modelMapperService.forResponse()
	                .map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> searchByCarPlate(String carPlate) {
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarPlateContainingIgnoreCase(carPlate);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(filter -> modelMapperService.forResponse()
	                .map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> searchByCarBrandName(String carBrandName) {
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarBrandNameContainingIgnoreCase(carBrandName);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(filter -> modelMapperService.forResponse()
	                .map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> searchByCarModelName(String carModelName) {
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarModelNameContainingIgnoreCase(carModelName);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(filter -> modelMapperService.forResponse()
	                .map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> getByCarModelYear(int carModelYear) {
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarModelYear(carModelYear);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(filter -> modelMapperService.forResponse()
	                .map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public List<GetAllFilterResponse> getByCarState(int carState) {
	    	
	        List<CarFilter> filters = carFilterRepository.findByCarState(carState);
	        
	        List<GetAllFilterResponse> response = filters.stream()
	                .map(filter -> modelMapperService.forResponse()
	                .map(filter, GetAllFilterResponse.class)).collect(Collectors.toList());

	        return response;
	    }

	    @Override
	    public CarFilter getByCarId(String id) {
	        return carFilterRepository.findByCarId(id);
	    }

	    @Override
	    public List<CarFilter> getByCarModelId(String carModelId) {
	        return carFilterRepository.findByCarModelId(carModelId);
	    }

	    @Override
	    public List<CarFilter> getByCarBrandId(String carBrandId) {
	        return carFilterRepository.findByCarBrandId(carBrandId);
	    }

	    @Override
	    public void save(CarFilter carFilter) {
	    	carFilterRepository.save(carFilter);
	    }

	    @Override
	    public void delete(String id) {
	    	carFilterRepository.deleteByCarId(id);
	    }

	    @Override
	    public void deleteAllByCarBrandId(String carBrandId) {
	    	carFilterRepository.deleteAllByCarBrandId(carBrandId);
	    }

	    @Override
	    public void deleteAllByCarModelId(String carModelId) {
	    	carFilterRepository.deleteAllByCarModelId(carModelId);
	    }
	    
	    private void checkIfExistByPlate(String carPlate) {
	        if (!carFilterRepository.existsByCarPlate(carPlate)) {
	            throw new RuntimeException("Filter Not Exists");
	        }
	    }
}
