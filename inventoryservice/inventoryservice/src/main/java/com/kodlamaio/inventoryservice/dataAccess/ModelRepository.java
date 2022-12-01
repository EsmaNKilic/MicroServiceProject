package com.kodlamaio.inventoryservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.inventoryservice.entities.Model;

public interface ModelRepository extends JpaRepository<Model, String>{
	boolean existsByName(String name);
}
