package com.lifeinsurance.exception;

public class UnauthorizedException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String details;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getDetails() {
		return details;
	}
	
	public UnauthorizedException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public UnauthorizedException(String errorMessage, String details) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.details = details;
	}
	public UnauthorizedException() {
		super();
	}
}
