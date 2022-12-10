package com.kodlama.filterService.dataAccess;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kodlama.filterService.entities.CarFilter;

public interface CarFilterRepository extends MongoRepository<CarFilter,String>{
	
	List<CarFilter> findByCarBrandId(String carBrandId);
	List<CarFilter> findByCarBrandNameIgnoreCase(String carBrandName);
	List<CarFilter> findByCarBrandNameContainingIgnoreCase(String carBrandName);
	
	List<CarFilter> findByCarModelId(String carModelId);
	List<CarFilter> findByCarModelNameIgnoreCase(String carModelName);
	List<CarFilter> findByCarModelNameContainingIgnoreCase(String carModelName);
	List<CarFilter> findByCarModelYear(int carModelYear);
	
	List<CarFilter> findByCarPlateIgnoreCase(String carPlate);
	List<CarFilter> findByCarPlateContainingIgnoreCase(String carPlate);

	List<CarFilter> findByCarState(int carState);
	 
	CarFilter findByCarId(String carId);
	 
	void deleteByCarId(String carId);
	void deleteAllByCarBrandId(String carBrandId);
	void deleteAllByCarModelId(String carModelId);
	
	boolean existsByCarPlate(String carPlate);
}
