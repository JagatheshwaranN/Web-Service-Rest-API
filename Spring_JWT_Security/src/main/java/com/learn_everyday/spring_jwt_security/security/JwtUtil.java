package com.learn_everyday.spring_jwt_security.security;

import com.learn_everyday.spring_jwt_security.entity.Role;
import com.learn_everyday.spring_jwt_security.entity.User;
import com.learn_everyday.spring_jwt_security.repository.UserRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    @Autowired
    private final UserRepository userRepository;

    private final SecretKey SECRET_KEY = Jwts.SIG.HS512.key().build();

    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        User foundUser = user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Set<Role> roles = foundUser.getRoles();
        int jwtExpireMillis = 3600000;
        return Jwts.builder().subject(username).claim("roles", roles
                        .stream().map(Role::getName).collect(Collectors.joining(",")))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExpireMillis))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public Set<String> extractRoles(String token) {
        String roles = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload().get("roles", String.class);
        return Set.of(roles.split(","));
    }

    public boolean isTokenValid(String token) {
        try {
            Date expiry = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload()
                    .getExpiration();
            return expiry.after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

}
