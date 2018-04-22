package com.salvation.domain;

import lombok.Data;

@Data
public class Weather {

	private String condition;

	private Integer temperature;

	private Integer precipitation;

	private Integer snowFall;

	private Double co2Emission;

	private Double nitrogenLevel;

}
