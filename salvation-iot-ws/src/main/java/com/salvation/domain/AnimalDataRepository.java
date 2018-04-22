package com.salvation.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalDataRepository {

	private List<AnimalData> animalData;

	public AnimalDataRepository() {
		animalData = new ArrayList<>();
		AnimalData animal = new AnimalData();
		animal.setCondition("Sunny");
		animal.setCo2Emission(81.00);
		animal.setNitrogenLevel(55.0);
		animal.setPrecipitation(0);
		animal.setTemperature(56);
		animal.setSnowFall(17);
		animalData.add(animal);

		animal = new AnimalData();
		animal.setCondition("Cloudy");
		animal.setCo2Emission(80.00);
		animal.setNitrogenLevel(54.0);
		animal.setPrecipitation(0);
		animal.setTemperature(56);
		animal.setSnowFall(8);
		animalData.add(animal);

		animal = new AnimalData();
		animal.setCondition("Sunny");
		animal.setCo2Emission(81.00);
		animal.setNitrogenLevel(55.0);
		animal.setPrecipitation(10);
		animal.setTemperature(60);
		animal.setSnowFall(0);
		animalData.add(animal);

		animal = new AnimalData();
		animal.setCondition("Cloudy");
		animal.setCo2Emission(81.00);
		animal.setNitrogenLevel(55.0);
		animal.setPrecipitation(10);
		animal.setTemperature(40);
		animal.setSnowFall(0);
		animalData.add(animal);

		animal = new AnimalData();
		animal.setCondition("Sunny");
		animal.setCo2Emission(82.00);
		animal.setNitrogenLevel(56.0);
		animal.setPrecipitation(15);
		animal.setTemperature(40);
		animal.setSnowFall(0);
		animalData.add(animal);

		animal = new AnimalData();
		animal.setCondition("Thunderstorm");
		animal.setCo2Emission(82.00);
		animal.setNitrogenLevel(56.0);
		animal.setPrecipitation(45);
		animal.setTemperature(40);
		animal.setSnowFall(0);
		animalData.add(animal);
	}

	public AnimalData getAnimalData(String id, Double lat, Double lng) {
		Random rand = new Random();
		int random = rand.nextInt(animalData.size());
		AnimalData data = animalData.get(random);
		return data;
	}

}
