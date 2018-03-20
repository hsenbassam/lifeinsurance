package com.lifeinsurance.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WholeLifeRates{
	
	private static final List<Rate> BASIC_RATES = Arrays.asList(new Rate(18, 24, 0.25), new Rate(25, 29, 0.3),
			new Rate(30, 34, 0.34), new Rate(35, 39, 0.41), new Rate(40, 44, 0.5), new Rate(45, 49, 0.7),
			new Rate(50, 54, 0.78), new Rate(55, 59, 1.2), new Rate(60, 64, 1.3), new Rate(65, 69, 1.8),
			new Rate(70, 94, 4.3));

	private static final List<Rate> PLUS_RATES = Arrays.asList(new Rate(18, 24, 0.27), new Rate(25, 29, 0.32),
			new Rate(30, 34, 0.36), new Rate(35, 39, 0.42), new Rate(40, 44, 0.58), new Rate(45, 49, 0.72),
			new Rate(50, 54, 0.82), new Rate(55, 59, 1.23), new Rate(60, 64, 1.4), new Rate(65, 69, 2.1),
			new Rate(70, 94, 4.5));

	private static final List<Rate> ULTRA_RATES = Arrays.asList(new Rate(18, 24, 0.28), new Rate(25, 29, 0.328),
			new Rate(30, 34, 0.38), new Rate(35, 39, 0.435), new Rate(40, 44, 0.62), new Rate(45, 49, 0.74),
			new Rate(50, 54, 0.88), new Rate(55, 59, 1.26), new Rate(60, 64, 1.6), new Rate(65, 69, 2.4),
			new Rate(70, 94, 4.7));
	
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
