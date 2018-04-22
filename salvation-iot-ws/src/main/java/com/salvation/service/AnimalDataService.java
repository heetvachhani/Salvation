package com.salvation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.salvation.domain.AnalyzeRequest;
import com.salvation.domain.AnalyzeResponse;
import com.salvation.domain.CriticalAnimalData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@EnableAsync
@EnableScheduling
public class AnimalDataService {

	@Autowired
	private StringRedisTemplate redisTemplate;

	public void performManualProcessing() {

	}

	public List<CriticalAnimalData> getProcessedData() {
		return null;
	}

	@Async
	public void performManualAsyncProcessing() {
		log.info("Async performance started");
	}

	@Scheduled(fixedRate = 60 * 1000)
	public void performAutoProcessing() {
		try {

		} catch (Exception e) {
			log.error("Failed to perform processing: {}", e);
		}

	}

	public AnalyzeResponse analyzeAnimalData(AnalyzeRequest request) {
		AnalyzeResponse response = new AnalyzeResponse();
		response.setQrCode(request.getQrCode());
		response.setCondition("Sunny");
		response.setCo2Emission(81.00);
		response.setNitrogenLevel(55.0);
		response.setPrecipitation(0);
		response.setTemperature(56);
		response.setRiskFactor("LOW");
		response.setSnowFall(17);
		return response;
	}

}
