package com.lifeinsurance.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private String timestamp;
	private int errorCode;
	private HttpStatus errorStatus;
	private String message;
	private String details;
	private String url;
	
	

	public ErrorResponse() {
		super();
		String timestamp = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Timestamp(System.currentTimeMillis()));
		this.timestamp = timestamp;
	}
	

	public ErrorResponse(HttpStatus errorStatus, String message, String details, String url) {
		super();
		String timestamp = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Timestamp(System.currentTimeMillis()));
		this.timestamp = timestamp;
		this.errorCode = errorStatus.value();
		this.errorStatus = errorStatus;
		this.message = message;
		this.details = details;
		this.url = url;
	}
	public ErrorResponse(HttpStatus errorStatus, String message, String url) {
		this(errorStatus,message,null,url);
	}


	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpStatus getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(HttpStatus errorStatus) {
		this.errorStatus = errorStatus;
	}

	

	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}
	
	



}