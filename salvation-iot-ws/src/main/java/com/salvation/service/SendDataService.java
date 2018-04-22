package com.salvation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.salvation.domain.AnimalData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@EnableAsync
public class SendDataService {

	@Value("${push.data.url}")
	private String sendDataUrl;

	@Autowired
	public RestTemplate restTemplate;

	@Async
	public void sendData(AnimalData animalData) {
		try {
			log.info("Sending animal data: {}", animalData);
			String response = restTemplate.postForObject(sendDataUrl, animalData, String.class);
			log.info("Animal Post response: {}", response);
		} catch (Exception e) {
			log.error("Failed to post animal data: {}", e);
		}
	}

}
