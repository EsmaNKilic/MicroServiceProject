package com.kodlama.filterService.business.abstracts;

import java.util.List;

import com.kodlama.filterService.business.responses.GetAllFilterResponse;
import com.kodlama.filterService.entities.CarFilter;

public interface CarFilterService {

	List<GetAllFilterResponse> getAll();
    List<GetAllFilterResponse> getByCarBrandName(String carBrandName);
    List<GetAllFilterResponse> getByCarModelName(String carModelName);
    List<GetAllFilterResponse> getByCarPlate(String carPlate);
    List<GetAllFilterResponse> searchByCarPlate(String carPlate);
    List<GetAllFilterResponse> searchByCarBrandName(String carBrandName);
    List<GetAllFilterResponse> searchByCarModelName(String carModelName);
    List<GetAllFilterResponse> getByCarModelYear(int carModelYear);
    List<GetAllFilterResponse> getByCarState(int carState);

    // For Consumer Services
    
    CarFilter getByCarId(String id);
    List<CarFilter> getByCarModelId(String carModelId);
    List<CarFilter> getByCarBrandId(String carBrandId);
    void save(CarFilter mongodb);
    void delete(String id);
    void deleteAllByCarBrandId(String carBrandId);
    void deleteAllByCarModelId(String carModelId);
}
 