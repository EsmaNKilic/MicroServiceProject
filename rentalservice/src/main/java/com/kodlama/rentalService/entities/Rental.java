package com.kodlama.rentalService.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rentals")
public class Rental {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="car_id")
	private String carId;
	
	@Column(name="date_started")
	private LocalDateTime dateStarted = LocalDateTime.now();
	
	@Column(name="rented_for_days")
	private int rentedForDays;
	
	@Column(name="daily_price")
	private double dailyPrice;
	
	@Column(name="total_price")
	private double totalPrice;
	
}
