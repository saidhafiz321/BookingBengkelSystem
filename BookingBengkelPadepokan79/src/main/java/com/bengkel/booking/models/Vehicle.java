package com.bengkel.booking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Vehicle {
	private String vehiclesId;
	private String color;
	private String brand;
	private String transmisionType;
	private int yearRelease;
	private String vehicleType;

	
}
