package com.lifeinsurance.security;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifeinsurance.exception.JwtAuthenticationException;
import com.lifeinsurance.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	@Autowired
	byte[] signingKey;

	private Claims body;

	@SuppressWarnings("unchecked")
	public JwtUser validate(String token) {

		JwtUser jwtUser = null;
		try {
			body = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();

			jwtUser = new JwtUser();
			jwtUser.setEmail(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get("id")));
			jwtUser.setRole((List<String>) body.get("role"));
		} catch (Exception e) {
			throw new JwtAuthenticationException("JWT is incorrect", e);
		}
		if (this.isTokenExpired()) {
			throw new JwtAuthenticationException("JWT is Expired ");
		}

		return jwtUser;
	}

	private Date generateCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	private Boolean isTokenExpired() {
		final Date expiration = body.getExpiration();
		return expiration.before(this.generateCurrentDate());
	}

}
