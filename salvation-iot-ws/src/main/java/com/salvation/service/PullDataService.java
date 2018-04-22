package com.salvation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvation.domain.AnalyzeRequest;
import com.salvation.domain.AnimalData;
import com.salvation.domain.AnimalDataRepository;

@Service
public class PullDataService {

	@Autowired
	private AnimalDataRepository animalDataRepository;

	public AnimalData getAnimalData(AnalyzeRequest request) {
		AnimalData data = animalDataRepository.getAnimalData(request.getQrCode(), request.getPos().getLat(),
				request.getPos().getLng());
		return data;
	}

}
