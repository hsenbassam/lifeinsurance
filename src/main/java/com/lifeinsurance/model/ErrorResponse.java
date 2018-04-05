package com.lifeinsurance.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private int errorCode;
	private HttpStatus errorStatus;
	private String message;
	private String details;
	private String url;
	
	

	public ErrorResponse() {
		super();
		timestamp = LocalDateTime.now();
	}
	

	public ErrorResponse(HttpStatus errorStatus, String message, String details, String url) {
		super();
		this.timestamp = LocalDateTime.now();
		this.errorCode = errorStatus.value();
		this.errorStatus = errorStatus;
		this.message = message;
		this.details = details;
		this.url = url;
	}
	public ErrorResponse(HttpStatus errorStatus, String message, String url) {
		//super();
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}
	
	



}