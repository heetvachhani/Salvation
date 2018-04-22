package com.salvation.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CriticalAnimalData {

	private String tagNumber; 
	
	private String animalName;
	
	private String criticalLevel;
	
	private String report;
	
	private Date lastProcessedTime;
}
