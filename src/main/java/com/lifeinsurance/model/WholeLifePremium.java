package com.lifeinsurance.model;

public class WholeLifePremium extends Premium{
	
	public WholeLifePremium() {
		super();
	}

	public WholeLifePremium(double basic_monthly, double plus_monthly, double ultra_monthly) {
		super(basic_monthly,plus_monthly,ultra_monthly);
	}
}
