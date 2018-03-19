package com.lifeinsurance.service;

import com.lifeinsurance.model.Premium;
import com.lifeinsurance.model.Quote;
import com.lifeinsurance.model.Rates;
import com.lifeinsurance.utils.Converter;

public class SimulatorServiceImpl implements SimulatorService{

	@Override
	public Premium getTermLifePremium(Quote quote) {
		
		long age = Converter.birthdayToAge(quote.getBirthday());
		
		double basicRate = Rates.getBasicRate(age);
		double plusRate = Rates.getPlusRate(age);
		double ultraRate = Rates.getUltraRate(age);
		

		Premium premium = new Premium();
		
		premium.setBasic_monthly(quote.getAmount() / 1000 * basicRate);
		premium.setPlus_monthly(quote.getAmount() / 1000 * plusRate);
		premium.setUltra_monthly( quote.getAmount() / 1000 * ultraRate);

		return premium;
	}

}
