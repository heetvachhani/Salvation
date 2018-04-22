package com.salvation.service;

import java.util.List;

import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.salvation.domain.AnalyzeRequest;
import com.salvation.domain.AnalyzeResponse;
import com.salvation.domain.AnimalData;
import com.salvation.domain.CriticalAnimalData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@EnableAsync
@EnableScheduling
public class AnimalDataService {

	// @Autowired
	// private StringRedisTemplate redisTemplate;

	// @Autowired
	private MultiLayerNetwork multiLayerNetwork;

	@Autowired
	private PullDataService pullDataService;

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
		BeanUtils.copyProperties(request, response);
		AnimalData data = pullDataService.getAnimalData(request);
		// Calculate risk factor
		String riskFactor = getRiskFactor(request.getAnimalName(), data);
		response.setRiskFactor(riskFactor);
		response.setData(data);
		return response;
	}

	private String getRiskFactor(String animalName, AnimalData data) {
		String riskFactor = "";
		if (multiLayerNetwork != null) {
			// get from trained model
			multiLayerNetwork.computeGradientAndScore();
			// prepare data.
			// DataSet dataset = new DataSet(data);
			// riskFactor = multiLayerNetwork.predict(dataSet);

		} else {
			if (data.getCondition().equals("Thunderstorm")) {
				riskFactor = "HIGH";
			} else {
				riskFactor = "LOW";
			}
		}
		return riskFactor;
	}

	public MultiLayerNetwork multiLayerNetwork() {
		try {
			// Nd4jBackend.load();

			// FileInputStream modelConfigStream = new FileInputStream(new
			// ClassPathResource(ECO_SAVIOR_MODEL_CONFIG).getFile());
			// FileInputStream modelFileStream = new FileInputStream(new
			// ClassPathResource(ECO_SAVIOR_MODEL_H5).getFile());
			// MultiLayerNetwork network =
			// KerasModelImport.importKerasSequentialModelAndWeights(
			// new ClassPathResource(ECO_SAVIOR_MODEL_H5).getFile().getPath());

			MultiLayerNetwork network = KerasModelImport.importKerasSequentialModelAndWeights(
					"/Users/hbhavsar/git/salvation-iot-ws/src/main/resources/trained_models/eco-savior-model.json",
					"/Users/hbhavsar/git/salvation-iot-ws/src/main/resources/trained_models/eco-savior-model.h5");
			return network;
		} catch (Exception e) {
			log.error("Failed to load ML Model {}", e);
			throw new RuntimeException("Failed to load Eco Savior model:" + e.getMessage());
		}
	}

}
