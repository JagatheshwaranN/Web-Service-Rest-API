package com.learn_everyday.learn_aop.learn_aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn_everyday.learn_aop.learn_aop.aspect.TrackTime;
import com.learn_everyday.learn_aop.learn_aop.data.Dao1;

@Component
public class Business1 {
	
	@Autowired
	private Dao1 dao1;
	
	@TrackTime
	public String processData() {
		return dao1.retrieveData();
	}
}
