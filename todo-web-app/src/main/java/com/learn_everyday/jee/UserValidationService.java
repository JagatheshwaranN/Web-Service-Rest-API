package com.learn_everyday.jee;

public class UserValidationService {

	public boolean isUserValid(String username, String password) {
		if(username.equals("john") && password.equals("secret"))
			return true;
		return false;
	}
	
}
