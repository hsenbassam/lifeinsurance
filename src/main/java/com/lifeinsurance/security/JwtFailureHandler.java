package com.lifeinsurance.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.google.gson.Gson;
import com.lifeinsurance.model.ErrorResponse;

public class JwtFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		Gson gson = new Gson();
		ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED, exception.getMessage(),
				request.getRequestURL().toString());
		String errorJson = gson.toJson(error);
		response.getOutputStream().println(errorJson);

	}

}
