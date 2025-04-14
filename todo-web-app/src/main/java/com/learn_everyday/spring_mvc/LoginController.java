package com.learn_everyday.spring_mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn_everyday.login.LoginService;

@Controller
public class LoginController {
	
//	@RequestMapping(value = "/login")
//	@ResponseBody
//	public String sayHello() {
//		return "Welcome to Spring MVC";
//	}
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	// Model can used to pass the data between the controller and view.
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
		
		if(!loginService.isUserValid(name, password)) {
			modelMap.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		modelMap.put("name", name);
		modelMap.put("password", password);
		return "welcome";
	}

}
