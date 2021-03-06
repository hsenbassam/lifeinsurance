package com.lifeinsurance.service;

import com.lifeinsurance.model.Premium;
import com.lifeinsurance.model.Quote;

public interface SimulatorService {
	
	public Premium getTermLifePremium(Quote quote);
	
	public Premium getWholeLifePremium(Quote quote);
	
	public Premium getUniversalLifePremium(Quote quote);

}
