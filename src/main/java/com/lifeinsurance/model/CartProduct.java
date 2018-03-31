package com.lifeinsurance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartProduct {
	
	private int id;
	private String type;
	@JsonProperty("package")
	private String product_package;
	private double amount;
	private String coverage;
	private double premium;
	
	
	
	public CartProduct() {
		super();
	}


	public CartProduct(int id, String type, String product_package, double amount, String coverage, double premium) {
		super();
		this.id = id;
		this.type = type;
		this.product_package = product_package;
		this.amount = amount;
		this.coverage = coverage;
		this.premium = premium;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getProduct_package() {
		return product_package;
	}


	public void setProduct_package(String product_package) {
		this.product_package = product_package;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getCoverage() {
		return coverage;
	}


	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}


	public double getPremium() {
		return premium;
	}


	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	
	
	

}
