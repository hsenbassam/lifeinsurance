package com.lifeinsurance.model;

public class Quote {
	
	private String gender;
	private String birthday;
	private String country;
	private String marial;
	private int coverage;
	private double amount;
	private double monthly_income;
	private boolean health1;
	private boolean health2;
	private boolean health3;
	
	
	public Quote() {
		super();
	}


	public Quote(String gender, String birthday, String country, String marial, int coverage, double amount,
			double monthly_income, boolean health1, boolean health2, boolean health3) {
		super();
		this.gender = gender;
		this.birthday = birthday;
		this.country = country;
		this.marial = marial;
		this.coverage = coverage;
		this.amount = amount;
		this.monthly_income = monthly_income;
		this.health1 = health1;
		this.health2 = health2;
		this.health3 = health3;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}



	public String getMarial() {
		return marial;
	}


	public void setMarial(String marial) {
		this.marial = marial;
	}


	public int getCoverage() {
		return coverage;
	}


	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getMonthly_income() {
		return monthly_income;
	}


	public void setMonthly_income(double monthly_income) {
		this.monthly_income = monthly_income;
	}


	public boolean isHealth1() {
		return health1;
	}


	public void setHealth1(boolean health1) {
		this.health1 = health1;
	}


	public boolean isHealth2() {
		return health2;
	}


	public void setHealth2(boolean health2) {
		this.health2 = health2;
	}


	public boolean isHealth3() {
		return health3;
	}


	public void setHealth3(boolean health3) {
		this.health3 = health3;
	}
	

}
