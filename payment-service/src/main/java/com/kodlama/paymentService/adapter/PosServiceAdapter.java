package com.kodlama.paymentService.adapter;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.kodlama.paymentService.business.abstracts.PosService;
import com.kodlamaio.common.utilities.exceptions.BusinessException;

@Service
public class PosServiceAdapter implements PosService{

	@Override
	public void pay() {
		
		int randomNumber = new Random().nextInt(2);
		
        if (randomNumber == 1) {
        	
            throw new BusinessException("PAYMENT FAILED");
        }
		
	}

}
