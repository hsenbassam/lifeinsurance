package com.lifeinsurance.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TermLifeRates {

	private static final List<Rate> BASIC_RATES = Arrays.asList(new Rate(18, 24, 0.039), new Rate(25, 29, 0.047),
			new Rate(30, 34, 0.061), new Rate(35, 39, 0.068), new Rate(40, 44, 0.076), new Rate(45, 49, 0.115),
			new Rate(50, 54, 0.176), new Rate(55, 59, 0.337), new Rate(60, 64, 0.506), new Rate(65, 69, 1.004),
			new Rate(70, 94, 1.608));

	private static final List<Rate> PLUS_RATES = Arrays.asList(new Rate(18, 24, 0.043), new Rate(25, 29, 0.055),
			new Rate(30, 34, 0.067), new Rate(35, 39, 0.073), new Rate(40, 44, 0.097), new Rate(45, 49, 0.130),
			new Rate(50, 54, 0.196), new Rate(55, 59, 0.437), new Rate(60, 64, 0.806), new Rate(65, 69, 1.304),
			new Rate(70, 94, 1.908));

	private static final List<Rate> ULTRA_RATES = Arrays.asList(new Rate(18, 24, 0.048), new Rate(25, 29, 0.063),
			new Rate(30, 34, 0.070), new Rate(35, 39, 0.083), new Rate(40, 44, 0.114), new Rate(45, 49, 0.154),
			new Rate(50, 54, 0.220), new Rate(55, 59, 0.547), new Rate(60, 64, 1.020), new Rate(65, 69, 1.574),
			new Rate(70, 94, 2.040));

	public static double getBasicRate(long age) {

		return BASIC_RATES.stream().filter(r -> (age >= r.getMin_age() && age <= r.getMax_age()))
				.collect(Collectors.toList()).get(0).getValue();
	}

	public static double getPlusRate(long age) {

		return PLUS_RATES.stream().filter(r -> (age >= r.getMin_age() && age <= r.getMax_age()))
				.collect(Collectors.toList()).get(0).getValue();
	}

	public static double getUltraRate(long age) {

		return ULTRA_RATES.stream().filter(r -> (age >= r.getMin_age() && age <= r.getMax_age()))
				.collect(Collectors.toList()).get(0).getValue();
	}

}
