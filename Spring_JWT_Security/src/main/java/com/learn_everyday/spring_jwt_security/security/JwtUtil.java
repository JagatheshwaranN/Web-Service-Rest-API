package com.learn_everyday.spring_jwt_security.security;

import com.learn_everyday.spring_jwt_security.entity.Role;
import com.learn_everyday.spring_jwt_security.entity.User;
import com.learn_everyday.spring_jwt_security.repository.UserRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

//    private static final SecretKey secretKey = generateSecretKey();
//
//    private static SecretKey generateSecretKey() {
//        try {
//            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");
//            keyGenerator.init(512);
//            return keyGenerator.generateKey();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private final SecretKey SECRET_KEY = Jwts.SIG.HS512.key().build();

    private final UserRepository userRepository;

    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        Set<Role> roles = user.get().getRoles();
        int jwtExpireMillis = 3600000;
        return Jwts.builder().subject(username).claim("roles", roles
                        .stream().map(Role::getName).collect(Collectors.joining(",")))
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpireMillis))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        token = token.trim();
        return Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public Set<String> extractRoles(String token) {
        token = token.trim();
        String roles = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload().get("roles", String.class);
        return Set.of(roles);
    }

    public boolean isTokenValid(String token) {
        token = token.trim();
        try {
            Date expiry = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload()
                    .getExpiration();
            return expiry.after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
