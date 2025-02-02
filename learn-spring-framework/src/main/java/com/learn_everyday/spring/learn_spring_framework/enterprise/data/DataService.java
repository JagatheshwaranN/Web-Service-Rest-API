package com.learn_everyday.spring.learn_spring_framework.enterprise.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataService {
	
	public List<Integer>  getData() {
		return Arrays.asList(10, 20, 30, 40);
	}
}
