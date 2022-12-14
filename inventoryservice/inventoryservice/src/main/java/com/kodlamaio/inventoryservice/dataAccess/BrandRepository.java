package com.kodlamaio.inventoryservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.inventoryservice.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {
	boolean existsByName(String name);
}
