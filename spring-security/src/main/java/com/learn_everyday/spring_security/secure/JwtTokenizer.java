package com.learn_everyday.spring_security.secure;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenizer {

	private static final String SECRET_KEY_STRING = "HpxrgwRamswXGSP9oyuRkdLUJTYZIJWa";
	private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

	public String generateToken(UserDetails userDetails) {
		return Jwts.builder().subject(userDetails.getUsername()).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() * 1000 * 60 * 60)).signWith(SECRET_KEY, Jwts.SIG.HS256)
				.compact();
	}

}
