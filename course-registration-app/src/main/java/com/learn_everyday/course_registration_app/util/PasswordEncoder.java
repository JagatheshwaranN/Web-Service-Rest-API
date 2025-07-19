package com.learn_everyday.course_registration_app.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		String pass = "admin123";
		String hashedPass = encoder.encode(pass);
		System.out.println(hashedPass);
	}

}
