package com.learn_everyday.rest.webservices.restful_web_services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3012285309008283831L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
