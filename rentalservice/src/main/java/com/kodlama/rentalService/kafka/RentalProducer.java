package com.kodlama.rentalService.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kodlamaio.common.events.payments.PaymentReceivedEvent;
import com.kodlamaio.common.events.rentals.RentalCreatedEvent;
import com.kodlamaio.common.events.rentals.RentalDeletedEvent;
import com.kodlamaio.common.events.rentals.RentalUpdatedEvent;

@Service
public class RentalProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(RentalProducer.class);

	private NewTopic topic;
	
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public RentalProducer(NewTopic topic, KafkaTemplate<String, Object> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	// PAYMENT
	
	public void sendMessage(PaymentReceivedEvent paymentReceivedEvent) {
		LOGGER.info(String.format("Payment received event => %s", paymentReceivedEvent.toString()));
		
		Message<PaymentReceivedEvent> message = MessageBuilder
				.withPayload(paymentReceivedEvent)
				.setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		
		kafkaTemplate.send(message); 
	}
	
	// RENTALS
	
	public void sendMessage(RentalCreatedEvent rentalCreatedEvent) {
		LOGGER.info(String.format("Rental created event => %s", rentalCreatedEvent.toString()));
		
		Message<RentalCreatedEvent> message = MessageBuilder
				.withPayload(rentalCreatedEvent)
				.setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		
		kafkaTemplate.send(message); 
	}
	
	public void sendMessage(RentalUpdatedEvent rentalUpdatedEvent) {
		LOGGER.info(String.format("Rental updated event => %s", rentalUpdatedEvent.toString()));
		
		Message<RentalUpdatedEvent> message = MessageBuilder
				.withPayload(rentalUpdatedEvent)
				.setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		
		kafkaTemplate.send(message);
	}
	
	public void sendMessage(RentalDeletedEvent rentalDeletedEvent) {
		LOGGER.info(String.format("Rental deleted event => %s", rentalDeletedEvent.toString()));
		
		Message<RentalDeletedEvent> message = MessageBuilder
				.withPayload(rentalDeletedEvent)
				.setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		
		kafkaTemplate.send(message);
	}
}
