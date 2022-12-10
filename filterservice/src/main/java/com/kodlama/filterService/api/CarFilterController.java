package com.kodlama.filterService.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.filterService.business.abstracts.CarFilterService;
import com.kodlama.filterService.business.responses.GetAllFilterResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/filters")
public class CarFilterController {
    private final CarFilterService carFilterService;

    @GetMapping
    public List<GetAllFilterResponse> getAll() {
        return carFilterService.getAll(); 
    }

    @GetMapping("/brand")
    public List<GetAllFilterResponse> getByBrandName(@RequestParam String carBrandName) {
        return carFilterService.getByCarBrandName(carBrandName);
    }

    @GetMapping("/model")
    public List<GetAllFilterResponse> getByModelName(@RequestParam String carModelName) {
        return carFilterService.getByCarModelName(carModelName);
    }

    @GetMapping("/plate")
    public List<GetAllFilterResponse> getByPlate(@RequestParam String carPlate) {
        return carFilterService.getByCarPlate(carPlate);
    }

    @GetMapping("/plate_search")
    public List<GetAllFilterResponse> searchByPlate(@RequestParam String carPlate) {
        return carFilterService.searchByCarPlate(carPlate);
    }

    @GetMapping("/brand_search")
    public List<GetAllFilterResponse> searchByBrandName(@RequestParam String carBrandName) {
        return carFilterService.searchByCarBrandName(carBrandName);
    }

    @GetMapping("/model_search")
    public List<GetAllFilterResponse> searchByModelName(@RequestParam String carModelName) {
        return carFilterService.searchByCarModelName(carModelName);
    }

    @GetMapping("/year")
    public List<GetAllFilterResponse> getByModelYear(@RequestParam int carModelYear) {
        return carFilterService.getByCarModelYear(carModelYear);
    }

    @GetMapping("/state")
    public List<GetAllFilterResponse> getByState(@RequestParam int carState) {
        return carFilterService.getByCarState(carState);
    }
}

