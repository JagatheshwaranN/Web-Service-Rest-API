package com.learn_everyday.spring_basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn_everyday.spring_basics.xml.XmlUserDAO;

@Configuration
public class SpingXmlConfigApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpingXmlConfigApplication.class);

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			XmlUserDAO userDAO1 = context.getBean(XmlUserDAO.class);
			LOGGER.info("{}", userDAO1);
			LOGGER.info("{}", userDAO1.getXmlJdbcConnection());
		}
	}
}
