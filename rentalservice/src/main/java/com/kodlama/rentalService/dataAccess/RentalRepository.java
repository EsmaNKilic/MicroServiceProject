package com.kodlama.rentalService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.rentalService.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, String>{
	
	
}
