package com.lifeinsurance.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lifeinsurance.model.JwtUser;

@Component
public class JwtValidator {


    private String secret = "secret";

    @SuppressWarnings("unchecked")
	public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("id")));
            jwtUser.setRole((List<String>) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
