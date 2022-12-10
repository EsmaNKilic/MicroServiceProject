package com.kodlama.rentalService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "paymentclient", url = "http://localhost:9011/")
public interface PaymentClient {
	
    @RequestMapping(method = RequestMethod.POST, value = "payment/api/payments/check")
    
    void checkIfPaymentSuccess(
    		@RequestParam String cardNumber,
            @RequestParam String nameOnCard,
            @RequestParam int cardExpirationYear,
            @RequestParam int cardExpirationMonth,
            @RequestParam String cvv,
            @RequestParam double pric);
}