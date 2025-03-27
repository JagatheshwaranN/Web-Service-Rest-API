package com.learn_everyday.use_spring_selenium.spring_selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.learn_everyday.use_spring_selenium.spring_selenium")
public class SpringSeleniumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeleniumApplication.class, args);
	}

}
