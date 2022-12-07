package com.kodlama.filterService.business.abstracts;

import java.util.List;

import com.kodlama.filterService.business.responses.GetAllFilterResponse;
import com.kodlama.filterService.entities.CarFilter;

public interface CarFilterService {

	List<GetAllFilterResponse> getAll();
    List<GetAllFilterResponse> getByBrandName(String brandName);
    List<GetAllFilterResponse> getByModelName(String modelName);
    List<GetAllFilterResponse> getByPlate(String plate);
    List<GetAllFilterResponse> searchByPlate(String plate);
    List<GetAllFilterResponse> searchByBrandName(String brandName);
    List<GetAllFilterResponse> searchByModelName(String modelName);
    List<GetAllFilterResponse> getByModelYear(int modelYear);
    List<GetAllFilterResponse> getByState(int state);

    // For Consumer Services
    
    CarFilter getByCarId(String id);
    List<CarFilter> getByModelId(String modelId);
    List<CarFilter> getByBrandId(String brandId);
    void save(CarFilter mongodb);
    void delete(String id);
    void deleteAllByBrandId(String brandId);
    void deleteAllByModelId(String modelId);
}
 