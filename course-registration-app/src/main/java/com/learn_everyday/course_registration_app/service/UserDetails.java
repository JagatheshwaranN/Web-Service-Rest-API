package com.learn_everyday.course_registration_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn_everyday.course_registration_app.entity.Users;
import com.learn_everyday.course_registration_app.repository.UserDetailsRepo;

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
