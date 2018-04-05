package com.lifeinsurance.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String details;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getDetails() {
		return details;
	}
	public NotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public NotFoundException(String errorMessage, String details) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.details = details;
	}
	public NotFoundException() {
		super();
	}
}
