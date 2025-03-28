package com.learn_everyday.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
//	@RequestMapping(value = "/login")
//	@ResponseBody
//	public String sayHello() {
//		return "Welcome to Spring MVC";
//	}
	
	@RequestMapping(value = "/login")
	public String sayHello() {
		return "login";
	}

}
