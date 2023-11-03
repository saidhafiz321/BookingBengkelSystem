package com.bengkel.booking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class Motorcyle extends Vehicle {
	private int engineCapacity;

	public Motorcyle(String vehiclesId, String color, String brand, String transmisionType, int yearRelease,
			int engineCapacity) {
		super(vehiclesId, color, brand, transmisionType, yearRelease, "Motorcyle");
		this.engineCapacity = engineCapacity;
	}
	
	
}
