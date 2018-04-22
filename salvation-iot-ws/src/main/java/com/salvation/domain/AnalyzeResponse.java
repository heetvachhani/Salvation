package com.salvation.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AnalyzeResponse extends Weather {

	private String qrCode;

	private String riskFactor;
}
