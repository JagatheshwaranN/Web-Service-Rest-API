package com.learn_everyday.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {

	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue filtering() {
		DynamicFilterBean bean = new DynamicFilterBean("value1", "value2", "value3");
		Set<String> filterProperties = new HashSet<String>();
		filterProperties.add("field1");
		filterProperties.add("field3");
		MappingJacksonValue mappingJacksonValue = applyCustomFilter(bean, filterProperties);
		return mappingJacksonValue;
	}

	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue filteringList() {
		List<DynamicFilterBean> list = Arrays.asList(new DynamicFilterBean("value1", "value2", "value3"),
				new DynamicFilterBean("value4", "value5", "value6"));
		Set<String> filterProperties = new HashSet<String>();
		filterProperties.add("field1");
		MappingJacksonValue mappingJacksonValue = applyCustomFilter(list, filterProperties);
		return mappingJacksonValue;
	}

	private MappingJacksonValue applyCustomFilter(Object obj, Set<String> filterOptions) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(obj);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filterOptions);
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilterBean", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

}
