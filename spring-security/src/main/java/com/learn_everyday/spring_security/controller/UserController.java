package com.learn_everyday.spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn_everyday.spring_security.model.Users;
import com.learn_everyday.spring_security.service.UserDetails;

@RestController
public class UserController {

	@Autowired
	UserDetails userDetails;

	@PostMapping("/admin/add-user")
	public void addUser(@RequestBody Users user) {
		userDetails.addUser(user);
	}

}
