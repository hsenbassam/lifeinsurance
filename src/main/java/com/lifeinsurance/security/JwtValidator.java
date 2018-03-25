package com.lifeinsurance.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lifeinsurance.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	@Value("signing-key:Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
	private String signingKey;

	@SuppressWarnings("unchecked")
	public JwtUser validate(String token) {

		JwtUser jwtUser = null;
		try {
			Claims body = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();

			jwtUser = new JwtUser();
			jwtUser.setEmail(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get("id")));
			jwtUser.setRole((List<String>) body.get("role"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jwtUser;
	}
}
