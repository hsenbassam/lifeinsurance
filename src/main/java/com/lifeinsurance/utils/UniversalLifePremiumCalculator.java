package com.lifeinsurance.utils;

import com.lifeinsurance.model.Quote;
import com.lifeinsurance.model.UniversalLifeRates;

public class UniversalLifePremiumCalculator {

	public static double getBasicAmount(Quote quote) {

		long age = Converter.birthdayToAge(quote.getBirthday());
		double basicRate = UniversalLifeRates.getBasicRate(age);

		double initialBasicAmount = quote.getAmount() / 1000 * basicRate;

		return applyFactorsOn(initialBasicAmount, quote);

	}

	public static double getPlusAmount(Quote quote) {

		long age = Converter.birthdayToAge(quote.getBirthday());
		double plusRate = UniversalLifeRates.getPlusRate(age);

		double initialPlusAmount = quote.getAmount() / 1000 * plusRate;

		return applyFactorsOn(initialPlusAmount, quote);

	}

	public static double getUltraAmount(Quote quote) {

		long age = Converter.birthdayToAge(quote.getBirthday());
		double ultraRate = UniversalLifeRates.getUltraRate(age);

		double initialUltraAmount = quote.getAmount() / 1000 * ultraRate;

		return applyFactorsOn(initialUltraAmount, quote);

	}

	private static double applyFactorsOn(double initialAmount, Quote quote) {

		double resultAmount = initialAmount;

		if (quote.getGender().equals("m"))
			resultAmount = resultAmount + initialAmount * 0.12;
		if (!quote.getCountry().equals("LB")) //Lebanon
			resultAmount = resultAmount + initialAmount * 0.2;
		if (quote.getOccupation().matches("65|66|67|68")) // Transportation Occupations - Military
			resultAmount = resultAmount + initialAmount * 0.2;
		if (quote.getMarial().matches("m|mc") )
			resultAmount = resultAmount + initialAmount * 0.1;
		if (quote.isHealth3())
			resultAmount = resultAmount + initialAmount * 0.6;
		if (quote.isHealth1())
			resultAmount = resultAmount + initialAmount * 0.03;
		if (quote.isHealth2())
			resultAmount = resultAmount + initialAmount * 0.03;
		return resultAmount;
	}



}
