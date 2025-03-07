package com.learn_everyday.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public FilterBean filtering() {
		return new FilterBean("value1", "value2", "value3");
	}

	
	@GetMapping("/filtering-list")
	public List<FilterBean> filteringList() {
		return Arrays.asList(new FilterBean("value1", "value2", "value3"),
				new FilterBean("value4", "value5", "value6"));
	}

}
