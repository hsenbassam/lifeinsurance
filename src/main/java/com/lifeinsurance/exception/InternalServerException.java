package com.lifeinsurance.exception;

public class InternalServerException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String details;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getDetails() {
		return details;
	}
	
	public InternalServerException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public InternalServerException(String errorMessage, String details) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.details = details;
	}
	public InternalServerException() {
		super();
	}
}
