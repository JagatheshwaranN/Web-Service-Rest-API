package com.learn_everyday.spring_basics.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalFile {

	@Value("${external.service.url}")
	private String url;

	public String retrieveUrl() {
		return url;
	}

}
