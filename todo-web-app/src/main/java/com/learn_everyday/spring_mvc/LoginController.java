package com.learn_everyday.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
//	@RequestMapping(value = "/login")
//	@ResponseBody
//	public String sayHello() {
//		return "Welcome to Spring MVC";
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
		modelMap.put("name", name);
		modelMap.put("password", password);
		return "welcome";
	}

}
