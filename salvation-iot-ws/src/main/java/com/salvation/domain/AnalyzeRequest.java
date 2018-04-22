package com.salvation.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AnalyzeRequest{

	@NotNull(message = "Required field qrCode can not be null")
	private String qrCode;
	
	@Valid
	@NotNull(message = "Required field pos can not be null")
	private Location pos;
}
