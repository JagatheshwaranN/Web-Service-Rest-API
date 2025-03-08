package com.learn_everyday.learn_aop.learn_aop.data;

import org.springframework.stereotype.Repository;

import com.learn_everyday.learn_aop.learn_aop.aspect.TrackTime;

@Repository
public class Dao1 {
	
	@TrackTime
	public String retrieveData() {
		return "Data1";
	}

}
