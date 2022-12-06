package com.kodlama.filterService.business.concretes;

import com.kodlama.filterService.business.abstracts.CarFilterService;
import com.kodlama.filterService.core.results.Result;
import com.kodlama.filterService.core.results.SuccessResult;
import com.kodlama.filterService.dataAccess.CarFilterRepository;
import com.kodlama.filterService.entities.CarFilter;

public class CarFilterManager implements CarFilterService{

	private CarFilterRepository carFilterRepository;
	
	@Override
	public Result add(CarFilter carFilter) {
		
		carFilterRepository.save(carFilter);
		
		return new SuccessResult();
	}

	@Override
	public Result update(CarFilter carFilter) {
		
		carFilterRepository.save(carFilter);
		
		return new SuccessResult();
	}

}
