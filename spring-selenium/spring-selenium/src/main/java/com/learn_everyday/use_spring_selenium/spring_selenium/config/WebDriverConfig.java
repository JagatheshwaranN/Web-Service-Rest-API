package com.learn_everyday.use_spring_selenium.spring_selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this class as Spring Configuration
public class WebDriverConfig {
	
	@Bean // Registers WebDriver as a Spring Bean
	public WebDriver getWebDriver() {
		return new ChromeDriver();
	}

}
