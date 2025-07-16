package com.learn_everyday.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn_everyday.spring_security.model.Users;
import com.learn_everyday.spring_security.repository.UserDetailsRepo;

@Service
public class UserDetails {

	@Autowired
	UserDetailsRepo userDetailsRepo;

	BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder(12);

	public void addUser(Users user) {
		user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));
		userDetailsRepo.save(user);
	}

}
