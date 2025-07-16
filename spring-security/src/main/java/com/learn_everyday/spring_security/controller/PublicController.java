package com.learn_everyday.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

	@GetMapping("/public/home")
	public String welcomeUser() {
		return "Hey! Welcome to our site..";
	}

}
