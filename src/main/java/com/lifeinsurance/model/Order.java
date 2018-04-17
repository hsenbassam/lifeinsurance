package com.lifeinsurance.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Order {
	
	private int id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
	private Timestamp timestamp;
	private String firstname;
	private String lastname;
	private String email;
	private String type;
	@JsonProperty("package")
	private String product_package;
	private double amount;
	private String coverage;
	private double premium;
	
	
	public Order() {
		super();
	}


	public Order(int id, Timestamp timestamp, String firstname, String lastname, String email, String type, String product_package,
			double amount, String coverage, double premium) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
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


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
