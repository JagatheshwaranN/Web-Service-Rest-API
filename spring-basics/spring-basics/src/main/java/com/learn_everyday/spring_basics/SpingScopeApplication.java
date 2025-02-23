package com.learn_everyday.spring_basics;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learn_everyday.spring_basics.scope.UserDAO;

@SpringBootApplication
public class SpingScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpingScopeApplication.class);
	public static void main(String[] args) {
		
		
		
		ApplicationContext context = SpringApplication.run(SpingScopeApplication.class, args);
		
		UserDAO userDAO1 = context.getBean(UserDAO.class);
		UserDAO userDAO2 = context.getBean(UserDAO.class);
		LOGGER.info("{}", userDAO1);
		LOGGER.info("{}",userDAO1.getJdbcConnection());
		LOGGER.info("{}",userDAO2);
		LOGGER.info("{}",userDAO2.getJdbcConnection());		
	}

}
