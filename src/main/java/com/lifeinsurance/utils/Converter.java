package com.lifeinsurance.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Converter {

	
	public static long birthdayToAge(String birthday) {
		
		int year = Integer.parseInt(birthday.split("-")[0]);
		int month = Integer.parseInt(birthday.split("-")[1]);
		int day = Integer.parseInt(birthday.split("-")[2]);
		LocalDate start = LocalDate.of(year, month, day);
		LocalDate end = LocalDate.now();
		long age = ChronoUnit.YEARS.between(start, end);
		return age;
	}
}
