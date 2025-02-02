package com.learn_everyday.spring.learn_spring_framework.enterprise.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn_everyday.spring.learn_spring_framework.enterprise.data.DataService;

@Component
public class BusinessService {
	
	// @Autowired
	public DataService dataService;
	
	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public long calculateSum() {
		List<Integer> data = dataService.getData();
		return data.stream().reduce(Integer::sum).get();
	}
}

