package com.lifeinsurance.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private int id;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String phone;
	private String birthday;
	private String datecreated;
	@JsonProperty("enabled")
	private boolean isenabled;
	private List<String> roles;
	
	public User() {}
	
	
	public User(int id, String email, String password, String firstname, String lastname, String address, String phone, boolean isenabled) {
		super();
		this.id= id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.isenabled = isenabled;
	}
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getDatecreated() {
		return datecreated;
	}


	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}


	public boolean isEnabled() {
		return isenabled;
	}


	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
	}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
	

	
  
	  
}
