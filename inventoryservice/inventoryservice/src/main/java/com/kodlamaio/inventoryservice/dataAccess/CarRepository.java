package com.kodlamaio.inventoryservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.inventoryservice.entities.Car;

public interface CarRepository extends JpaRepository<Car, String>{
	boolean existsByPlate(String name);
	void findByState(int state);
}
