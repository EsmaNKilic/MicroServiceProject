package com.kodlama.filterService.dataAccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kodlama.filterService.entities.CarFilter;

public interface CarFilterRepository extends MongoRepository<CarFilter,String>{

}
