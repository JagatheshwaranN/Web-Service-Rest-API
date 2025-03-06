package com.learn_everyday.learn_aop.learn_aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// PointCut
	// @AfterReturning(value = "execution(* com.learn_everyday.learn_aop.learn_aop.business.*.*(..))", returning = "result")
	@AfterReturning(value = "com.learn_everyday.learn_aop.learn_aop.aspect.CommonJointPointConfiguration.businessLayerExecution()", returning = "result")
	public void afterAspectReturning(JoinPoint joinpoint, Object result) {
		// Advice
		logger.info("{} returned with value {}", joinpoint, result);
	}
	
//	@AfterThrowing(value = "execution(* com.learn_everyday.learn_aop.learn_aop.business.*.*(..))", throwing = "exception")
//	public void afterAspectThrowing(JoinPoint joinpoint, Throwable exception) {
//		// Advice
//		logger.info("{} returned with exception {}", joinpoint, exception);
//	}
	
	// @After("execution(* com.learn_everyday.learn_aop.learn_aop.business.*.*(..))")
	@After("com.learn_everyday.learn_aop.learn_aop.aspect.CommonJointPointConfiguration.businessLayerExecution()")
	public void afterAspect(JoinPoint joinpoint) {
		// Advice
		logger.info("After execution of {}", joinpoint);
	}

}
