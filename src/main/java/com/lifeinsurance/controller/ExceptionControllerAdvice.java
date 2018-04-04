package com.lifeinsurance.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.exception.UnauthorizedException;
import com.lifeinsurance.model.ErrorResponse;

 
@ControllerAdvice
public class ExceptionControllerAdvice  {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> notFoundExceptionHandler(HttpServletRequest request,NotFoundException ex) {
		ErrorResponse error = 
				new ErrorResponse(HttpStatus.NOT_FOUND,ex.getErrorMessage(),ex.getDetails(),request.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<ErrorResponse> internalExceptionHandler(HttpServletRequest request,InternalServerException ex) {
		ErrorResponse error = 
				new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),ex.getDetails(),request.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorResponse> unauthorizedExceptionHandler(HttpServletRequest request,UnauthorizedException ex) {
		ErrorResponse error = 
				new ErrorResponse(HttpStatus.UNAUTHORIZED,ex.getMessage(),ex.getDetails(),request.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	
 
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request,Exception ex) {
//		ErrorResponse error = new ErrorResponse();
//		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//		error.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//		error.setMessage("Please contact your administrator");
//		error.setUrl(request.getRequestURL().toString());
//		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
//	}
}