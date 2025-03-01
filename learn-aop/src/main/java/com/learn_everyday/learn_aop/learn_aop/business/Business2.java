package com.learn_everyday.learn_aop.learn_aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn_everyday.learn_aop.learn_aop.data.Dao2;

@Component
public class Business2 {
	
	@Autowired
	private Dao2 dao2;
	
	public String processData() {
		return dao2.retrieveData();
	}
}
