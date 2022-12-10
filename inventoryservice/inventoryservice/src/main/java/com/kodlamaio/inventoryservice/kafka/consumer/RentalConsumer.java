package com.kodlamaio.inventoryservice.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kodlamaio.common.CarState;
import com.kodlamaio.common.events.rentals.CarRentalCreatedEvent;
import com.kodlamaio.common.events.rentals.CarRentalDeletedEvent;
import com.kodlamaio.common.events.rentals.CarRentalUpdatedEvent;
import com.kodlamaio.common.events.rentals.RentalCreatedEvent;
import com.kodlamaio.common.events.rentals.RentalDeletedEvent;
import com.kodlamaio.common.events.rentals.RentalUpdatedEvent;
import com.kodlamaio.inventoryservice.business.abstracts.CarService;
import com.kodlamaio.inventoryservice.kafka.producer.inventories.InventoryProducer;

@Service
public class RentalConsumer {
private static final Logger LOGGER = LoggerFactory.getLogger(RentalConsumer.class);
	
	private final CarService carService;
	private final InventoryProducer inventoryProducer;
	
	public RentalConsumer(CarService carService, InventoryProducer inventoryProducer) {
		
	    this.carService = carService;
	    this.inventoryProducer = inventoryProducer;
	}
	
	@KafkaListener (topics = "${spring.kafka.topic.name}", groupId = "rentalcreated")
	
	public void consume(RentalCreatedEvent event) {
		
		carService.updateCarState(CarState.RENTED);
		event.getCarId();
		CarRentalCreatedEvent carRentalCreatedEvent = new CarRentalCreatedEvent();
        carRentalCreatedEvent.setCarId(event.getCarId());
        carRentalCreatedEvent.setMessage("Car rented!");
        inventoryProducer.sendMessage(carRentalCreatedEvent);
        LOGGER.info("Car rented!");
		
		// save the order event into the database
	}
	
	@KafkaListener (topics = "${spring.kafka.topic.name}", groupId = "rentalupdated")
	
	public void consume(RentalUpdatedEvent event) {
		
		carService.updateCarState(CarState.AVAILABLE);
		event.getOldCarId();
        carService.updateCarState(CarState.RENTED);
        event.getNewCarId();
        CarRentalUpdatedEvent carRentalUpdatedEvent = new CarRentalUpdatedEvent();
        carRentalUpdatedEvent.setNewCarId(event.getNewCarId());
        carRentalUpdatedEvent.setOldCarId(event.getOldCarId());
        carRentalUpdatedEvent.setMessage("Car rented state updated!");
        inventoryProducer.sendMessage(carRentalUpdatedEvent);
        LOGGER.info("Car rented state updated!");
			
	}
	
	@KafkaListener (topics = "${spring.kafka.topic.name}", groupId = "rentaldeleted")
	
	public void consume(RentalDeletedEvent event) {
		
		carService.updateCarState(CarState.AVAILABLE);
		event.getCarId();
        CarRentalDeletedEvent carRentalDeletedEvent = new CarRentalDeletedEvent();
        carRentalDeletedEvent.setCarId(event.getCarId());
        carRentalDeletedEvent.setMessage("Car deleted from rental!");
        inventoryProducer.sendMessage(carRentalDeletedEvent);
        LOGGER.info("Car deleted from rental!");
		
	}
}
