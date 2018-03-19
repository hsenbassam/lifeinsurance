package com.lifeinsurance.service;

import com.lifeinsurance.model.Premium;
import com.lifeinsurance.model.Quote;
import com.lifeinsurance.utils.PremiumCalculator;

public class SimulatorServiceImpl implements SimulatorService{

	@Override
	public Premium getTermLifePremium(Quote quote) {
		
		Premium premium = new Premium(
				PremiumCalculator.getBasicAmount(quote),
				PremiumCalculator.getPlusAmount(quote),
				PremiumCalculator.getUltraAmount(quote));
		
		return premium;
	}

}
