package com.learn_everyday.sping_basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import componentscan.ComponentUserDAO;

// @SpringBootApplication
@Configuration
@ComponentScan("componentscan")
public class SpingComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpingComponentScanApplication.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpingComponentScanApplication.class);

		ComponentUserDAO userDAO1 = context.getBean(ComponentUserDAO.class);
		ComponentUserDAO userDAO2 = context.getBean(ComponentUserDAO.class);
		LOGGER.info("{}", userDAO1);
		LOGGER.info("{}", userDAO1.getJdbcConnection());
		LOGGER.info("{}", userDAO2);
		LOGGER.info("{}", userDAO2.getJdbcConnection());
	}

}
