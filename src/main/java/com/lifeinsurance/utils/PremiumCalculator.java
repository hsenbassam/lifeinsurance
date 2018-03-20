package com.lifeinsurance.utils;

import com.lifeinsurance.model.Quote;
import com.lifeinsurance.model.Rates;

public class PremiumCalculator {

	public static double getBasicAmount(Quote quote) {

		long age = Converter.birthdayToAge(quote.getBirthday());
		double basicRate = Rates.getBasicRate(age);

		double initialBasicAmount = quote.getAmount() / 1000 * basicRate;

		return applyFactorsOn(initialBasicAmount, quote);

	}

	public static double getPlusAmount(Quote quote) {

		long age = Converter.birthdayToAge(quote.getBirthday());
		double plusRate = Rates.getPlusRate(age);

		double initialPlusAmount = quote.getAmount() / 1000 * plusRate;

		return applyFactorsOn(initialPlusAmount, quote);

	}

	public static double getUltraAmount(Quote quote) {

		long age = Converter.birthdayToAge(quote.getBirthday());
		double ultraRate = Rates.getUltraRate(age);

		double initialUltraAmount = quote.getAmount() / 1000 * ultraRate;

		return applyFactorsOn(initialUltraAmount, quote);

	}

	private static double applyFactorsOn(double initialAmount, Quote quote) {

		double resultAmount = initialAmount;

		if (quote.getGender().equals("m"))
			resultAmount = resultAmount + initialAmount * 0.1;
		if (!quote.getCountry().equals("LB"))
			resultAmount = resultAmount + initialAmount * 0.2;
		if (quote.getOccupation().matches("65|66|67|68"))
			resultAmount = resultAmount + initialAmount * 0.2;
		if (quote.getMarial().matches("m|mc") )
			resultAmount = resultAmount + initialAmount * 0.1;
		if (quote.isHealth3())
			resultAmount = resultAmount + initialAmount * 1;
		if (quote.isHealth1())
			resultAmount = resultAmount + initialAmount * 0.02;
		if (quote.isHealth2())
			resultAmount = resultAmount + initialAmount * 0.02;
		switch (quote.getCoverage()) {
			case 20:
				resultAmount = resultAmount + initialAmount * 0.05; break;
			case 25:
				resultAmount = resultAmount + initialAmount * 0.1; break;
			case 30:
				resultAmount = resultAmount + initialAmount * 0.15; break;
			case 35:
				resultAmount = resultAmount + initialAmount * 0.2; break;
		}
		return resultAmount;
	}



}
