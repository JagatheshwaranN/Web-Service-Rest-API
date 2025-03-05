package com.learn_everyday.learn_aop.learn_aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.learn_everyday.learn_aop.learn_aop.business.*.*(..))")
	public void beforeAspect(JoinPoint joinpoint) {
		logger.info("Check for User Access");
		logger.info("Allow execution for {}", joinpoint);
	}

}
