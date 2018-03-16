package com.lifeinsurance.service;

import com.lifeinsurance.model.Premium;
import com.lifeinsurance.model.Quote;

public interface SimulatorService {
	
	public Premium getTermLifePremium(Quote quote);

}
