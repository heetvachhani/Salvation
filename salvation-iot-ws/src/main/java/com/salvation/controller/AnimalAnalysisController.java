package com.salvation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salvation.domain.AnalyzeRequest;
import com.salvation.domain.AnalyzeResponse;
import com.salvation.domain.CriticalAnimalData;
import com.salvation.service.AnimalDataService;

@RestController
public class AnimalAnalysisController {

	@Autowired
	private AnimalDataService animalDataService;

	@PostMapping("/analyze")
	public AnalyzeResponse analyze(@RequestBody @Valid AnalyzeRequest request) {
		return animalDataService.analyzeAnimalData(request);
	}

	@PostMapping("/process")
	public void process() {
		animalDataService.performManualProcessing();
	}

	@GetMapping("/process-data")
	public List<CriticalAnimalData> getProcessedData() {
		return animalDataService.getProcessedData();
	}
}
