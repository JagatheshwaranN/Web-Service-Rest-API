package com.learn_everyday.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean isUserValid(String username, String password) {
		if (username.equals("john") && password.equals("secret")) {
			return true;
		}
		return false;
	}

}
