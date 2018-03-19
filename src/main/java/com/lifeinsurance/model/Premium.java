package com.lifeinsurance.model;

public class Premium {
	
	private double basic_monthly;
	private double plus_monthly;
	private double ultra_monthly;
	
	
	
	public Premium() {
		super();
	}


	public Premium(double basic_monthly, double plus_monthly, double ultra_monthly) {
		super();
		this.basic_monthly = basic_monthly;
		this.plus_monthly = plus_monthly;
		this.ultra_monthly = ultra_monthly;
	}


	public double getBasic_monthly() {
		return basic_monthly;
	}


	public void setBasic_monthly(double basic_monthly) {
		this.basic_monthly = basic_monthly;
	}


	public double getPlus_monthly() {
		return plus_monthly;
	}


	public void setPlus_monthly(double plus_monthly) {
		this.plus_monthly = plus_monthly;
	}


	public double getUltra_monthly() {
		return ultra_monthly;
	}


	public void setUltra_monthly(double ultra_monthly) {
		this.ultra_monthly = ultra_monthly;
	}
	
}
