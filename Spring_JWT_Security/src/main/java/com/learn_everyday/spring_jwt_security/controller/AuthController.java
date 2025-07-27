package com.learn_everyday.spring_jwt_security.controller;

import com.learn_everyday.spring_jwt_security.dto.RegisterRequest;
import com.learn_everyday.spring_jwt_security.entity.Role;
import com.learn_everyday.spring_jwt_security.entity.User;
import com.learn_everyday.spring_jwt_security.repository.RoleRepository;
import com.learn_everyday.spring_jwt_security.repository.UserRepository;
import com.learn_everyday.spring_jwt_security.security.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@NoArgsConstructor
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        log.info("Encoded Password: {}", encodedPassword);
        newUser.setPassword(encodedPassword);
        Set<Role> roles = new HashSet<>();
        for(String roleName : registerRequest.getRoles()) {
            Role role = roleRepository.findByName(roleName).orElseThrow(()-> new RuntimeException("Role not found: "+roleName));
            roles.add(role);
        }
        newUser.setRoles(roles);
        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        }catch(Exception e) {
            log.error("Login Error: ", e);
        }
        String token = jwtUtil.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(token);
    }

}
