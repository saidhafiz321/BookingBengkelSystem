package com.bengkel.booking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemService {
	private String serviceId;
	private String serviceName;
	private String vehicleType;
	private double price;
	
	
}
