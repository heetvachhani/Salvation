package com.salvation.config;

import java.io.FileInputStream;

import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@AutoConfigureAfter(Nd4jBackend.class)
public class KerasTrainedModelConfiguration {

	private static final String ECO_SAVIOR_MODEL_CONFIG = "trained_models/eco-savior-model.json";
	
	private static final String ECO_SAVIOR_MODEL_H5 = "trained_models/eco-savior-model.h5";
	
//	@Bean
	public MultiLayerNetwork multiLayerNetwork() {
		try {
			Nd4jBackend.load();
			FileInputStream modelConfigStream = new FileInputStream(new ClassPathResource(ECO_SAVIOR_MODEL_CONFIG).getFile());
			FileInputStream modelFileStream = new FileInputStream(new ClassPathResource(ECO_SAVIOR_MODEL_H5).getFile());
			MultiLayerNetwork network = KerasModelImport.importKerasSequentialModelAndWeights(modelFileStream);
			
//			MultiLayerNetwork network = KerasModelImport.importKerasSequentialModelAndWeights(
//					"/Users/hbhavsar/git/salvation-iot-ws/src/main/resources/trained_models/eco-savior-model.json",
//					"/Users/hbhavsar/git/salvation-iot-ws/src/main/resources/trained_models/eco-savior-model.h5");
			return network;
		} catch (Exception e) {
			log.error("Failed to load ML Model {}", e);
			throw new RuntimeException("Failed to load Eco Savior model:" + e.getMessage());
		}
	}
}
