package com.learn_everyday.spring.learn_spring_framework.enterprise.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn_everyday.spring.learn_spring_framework.enterprise.business.BusinessService;

@Component
public class WebController {
	
	//@Autowired
	public BusinessService businessService;
	
	@Autowired
	public WebController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}

}
