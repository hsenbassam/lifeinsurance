package com.lifeinsurance.service;

import com.lifeinsurance.model.Premium;
import com.lifeinsurance.model.Quote;
import com.lifeinsurance.model.TermLifePremium;
import com.lifeinsurance.model.WholeLifePremium;
import com.lifeinsurance.utils.TermLifePremiumCalculator;
import com.lifeinsurance.utils.WholeLifePremiumCalculator;

public class SimulatorServiceImpl implements SimulatorService{

	@Override
	public Premium getTermLifePremium(Quote quote) {
		
		TermLifePremium premium = new TermLifePremium(
				TermLifePremiumCalculator.getBasicAmount(quote),
				TermLifePremiumCalculator.getPlusAmount(quote),
				TermLifePremiumCalculator.getUltraAmount(quote));
		
		return premium;
	}
	
	@Override
	public Premium getWholeLifePremium(Quote quote) {
		
		WholeLifePremium premium = new WholeLifePremium(
				WholeLifePremiumCalculator.getBasicAmount(quote),
				WholeLifePremiumCalculator.getPlusAmount(quote),
				WholeLifePremiumCalculator.getUltraAmount(quote));
		
		return premium;
	}

}
