package com.kodlama.paymentService.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.paymentService.business.abstracts.PaymentService;
import com.kodlama.paymentService.business.requests.CheckPaymentRequest;
import com.kodlama.paymentService.business.requests.CreatePaymentRequest;
import com.kodlama.paymentService.business.requests.UpdatePaymentRequest;
import com.kodlama.paymentService.business.responses.CreatePaymentResponse;
import com.kodlama.paymentService.business.responses.GetAllPaymentResponse;
import com.kodlama.paymentService.business.responses.GetPaymentResponse;
import com.kodlama.paymentService.business.responses.UpdatePaymentResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {

	private PaymentService paymentService;
	
	@GetMapping
	public List<GetAllPaymentResponse> getAll(){
		return this.paymentService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetPaymentResponse getById(@PathVariable String id) {
		return this.paymentService.getById(id);
	}
	
	@PostMapping
	public CreatePaymentResponse add(@RequestBody CreatePaymentRequest createPaymentRequest) {
		return this.paymentService.add(createPaymentRequest);
	}
	
	@PutMapping
	public UpdatePaymentResponse update(@RequestBody UpdatePaymentRequest updatePaymentRequest) {
		return this.paymentService.update(updatePaymentRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		paymentService.delete(id);
	}
	
	@PostMapping("/check")
    public void checkIfPaymentSuccess(
            @RequestParam String cardNumber,
            @RequestParam String nameOnCard,
            @RequestParam int cardExpirationYear,
            @RequestParam int cardExpirationMonth,
            @RequestParam String cvv,
            @RequestParam double price) {
		CheckPaymentRequest checkPaymentRequest = new CheckPaymentRequest(
				cardNumber,
                nameOnCard,
                cardExpirationYear,
                cardExpirationMonth,
                cvv,
                price);
		paymentService.checkIfPaymentSuccess(checkPaymentRequest);
    }
	
}
