package com.salvation.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AnalyzeResponse extends AnalyzeRequest {

	private String riskFactor;
	
	private AnimalData data;
}
