package com.lifeinsurance.model;

public class Rate {
	
	private long min_age;
	private long max_age;
	private double value;
	
	
	public Rate() {
		super();
	}


	public Rate(long min_age, long max_age, double value) {
		super();
		this.min_age = min_age;
		this.max_age = max_age;
		this.value = value;
	}


	public long getMin_age() {
		return min_age;
	}


	public void setMin_age(long min_age) {
		this.min_age = min_age;
	}


	public long getMax_age() {
		return max_age;
	}


	public void setMax_age(long max_age) {
		this.max_age = max_age;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}



}
