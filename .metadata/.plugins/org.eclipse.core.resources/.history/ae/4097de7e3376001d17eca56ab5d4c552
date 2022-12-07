package com.kodlama.invoiceService.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kodlama.invoiceService.business.abstracts.InvoiceService;
import com.kodlama.invoiceService.clients.CarClient;
import com.kodlama.invoiceService.entities.Invoice;
import com.kodlamaio.common.events.payments.PaymentReceivedEvent;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;

@Service
public class RentalConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(RentalConsumer.class);
	
		private final InvoiceService invoiceService;
		private final ModelMapperService modelMapperService;
		private final CarClient carClient;
	
	public RentalConsumer(InvoiceService invoiceService, ModelMapperService modelMapperService, CarClient carClient) {
		
	    this.invoiceService = invoiceService;
	    this.modelMapperService = modelMapperService;
	    this.carClient = carClient;
	}
	
	@KafkaListener (topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	
	public void consume(PaymentReceivedEvent event) {
		
		Invoice invoice = modelMapperService.forRequest().map(event, Invoice.class);
	    invoice.setDailyPrice(event.getDailyPrice());
	    invoice.setTotalPrice(event.getTotalPrice());

	    invoice.setBrandName(carClient.getCarResponse(event.getCarId()).getBrandName());
	    invoice.setModelName(carClient.getCarResponse(event.getCarId()).getModelName());
	    invoice.setModelYear(carClient.getCarResponse(event.getCarId()).getModelYear());
	    invoiceService.createInvoice(invoice);
	    
	    LOGGER.info("Invoice created for : {}", event.getNameOnCard());

	}
	
	
}
