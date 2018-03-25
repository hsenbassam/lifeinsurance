package com.lifeinsurance.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lifeinsurance.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	@Value("signing-key:Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
	private String signingKey;

	public String generate(JwtUser jwtUser) {

		Claims claims = Jwts.claims().setSubject(jwtUser.getEmail());
		claims.put("id", String.valueOf(jwtUser.getId()));
		claims.put("role", jwtUser.getRole());

		//KeySingleton.getInstance().generateKey();

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, signingKey).compact();
	}
}
