package com.lifeinsurance.model;

public class TermLifePremium extends Premium{
	
	public TermLifePremium() {
		super();
	}

	public TermLifePremium(double basic_monthly, double plus_monthly, double ultra_monthly) {
		super(basic_monthly,plus_monthly,ultra_monthly);
	}
}
