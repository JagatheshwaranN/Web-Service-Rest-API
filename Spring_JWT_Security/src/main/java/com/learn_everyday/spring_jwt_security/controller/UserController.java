package com.learn_everyday.spring_jwt_security.controller;

import com.learn_everyday.spring_jwt_security.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${role.admin}")
    private String adminRole;

    @Value("${role.user}")
    private String userRole;

    @GetMapping("/data")
    public ResponseEntity<String> getProtectedData(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            try {
                if (jwtUtil.isTokenValid(jwtToken)) {
                    String username = jwtUtil.extractUsername(jwtToken);
                    Set<String> roles = jwtUtil.extractRoles(jwtToken);
                    if (roles.contains(adminRole)) {
                        return ResponseEntity.ok("Welcome " + username + ", Here is the " + roles + " specific data.");
                    } else if (roles.contains(userRole)) {
                        return ResponseEntity.ok("Welcome " + username + ", Here is the " + roles + " specific data.");
                    } else {
                        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied. You don't have proper role to access the data.");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Token.");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authorization Header is missing / invalid.");
    }

}
