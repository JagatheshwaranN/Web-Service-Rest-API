package com.learn_everyday.spring_basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.learn_everyday.spring_basics.properties.ExternalFile;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class SpringBasicsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBasicsApplication.class, args);
		ExternalFile externalFile = context.getBean(ExternalFile.class);
		System.out.println(externalFile.retrieveUrl());
	}

}
