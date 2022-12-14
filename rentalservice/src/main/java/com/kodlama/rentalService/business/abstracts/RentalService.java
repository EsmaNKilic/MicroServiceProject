package com.kodlama.rentalService.business.abstracts;

import java.util.List;

import com.kodlama.rentalService.business.requests.CreatePaymentRequest;
import com.kodlama.rentalService.business.requests.CreateRentalRequest;
import com.kodlama.rentalService.business.requests.UpdateRentalRequest;
import com.kodlama.rentalService.business.response.CreateRentalResponse;
import com.kodlama.rentalService.business.response.GetAllRentalResponse;
import com.kodlama.rentalService.business.response.GetRentalResponse;
import com.kodlama.rentalService.business.response.UpdateRentalResponse;

public interface RentalService {
	List<GetAllRentalResponse> getAll();
	GetRentalResponse getById(String id);
	CreateRentalResponse add(CreateRentalRequest createRentalRequest, CreatePaymentRequest createPaymentRequest);
	UpdateRentalResponse update(UpdateRentalRequest updateRentalRequest);
	void delete(String id);
}
