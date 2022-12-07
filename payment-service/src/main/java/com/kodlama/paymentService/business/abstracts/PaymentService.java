package com.kodlama.paymentService.business.abstracts;

import java.util.List;

import com.kodlama.paymentService.business.requests.CheckPaymentRequest;
import com.kodlama.paymentService.business.requests.CreatePaymentRequest;
import com.kodlama.paymentService.business.requests.UpdatePaymentRequest;
import com.kodlama.paymentService.business.responses.CreatePaymentResponse;
import com.kodlama.paymentService.business.responses.GetAllPaymentResponse;
import com.kodlama.paymentService.business.responses.GetPaymentResponse;
import com.kodlama.paymentService.business.responses.UpdatePaymentResponse;

public interface PaymentService {

	List<GetAllPaymentResponse> getAll();
	GetPaymentResponse getById(String id);
	CreatePaymentResponse add(CreatePaymentRequest creatPaymentRequest);
	UpdatePaymentResponse update(UpdatePaymentRequest updatePaymentRequest);
	void delete(String id);
	void checkIfPaymentSuccess(CheckPaymentRequest checkPaymentRequest);
	
}
