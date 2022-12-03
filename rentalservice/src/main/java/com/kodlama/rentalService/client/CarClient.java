package com.kodlama.rentalService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "carclient", url = "http://localhost:9011/")
public interface CarClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "stock/api/cars/checkcaravailable/{id}")
	
    void checkIfCarAvailable(@PathVariable String id);
}