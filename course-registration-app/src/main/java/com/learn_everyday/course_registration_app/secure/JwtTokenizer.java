package com.learn_everyday.course_registration_app.secure;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenizer {

	private static final String SECRET_KEY_STRING = "HpxrgwRamswXGSP9oyuRkdLUJTYZIJWa";
	private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

	public String generateToken(UserDetails userDetails) {
		return Jwts.builder().subject(userDetails.getUsername()).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).signWith(SECRET_KEY, Jwts.SIG.HS256)
				.compact();
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		return extractUserName(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	public String extractUserName(String token) {
		return Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload().getSubject();
	}

	private boolean isTokenExpired(String token) {
		Date expiry = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload()
				.getExpiration();
		return expiry.before(new Date());
	}

}
