package com.salvation.domain;

import lombok.Data;

@Data
public class AnimalData {

	private String qrCode; 
	
	private String animalName;
	
	private Location location;
	
	private Weather weather;
	
}
