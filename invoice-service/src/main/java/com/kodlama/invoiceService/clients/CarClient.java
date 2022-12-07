package com.kodlama.invoiceService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kodlama.invoiceService.business.responses.GetCarResponse;

@FeignClient(value = "carclient", url = "http://localhost:9011/")
public interface CarClient {
    @RequestMapping(method = RequestMethod.GET, value = "inventoryservice/api/cars/getcarresponse/{id}")
    GetCarResponse getCarResponse(@PathVariable String id);
}