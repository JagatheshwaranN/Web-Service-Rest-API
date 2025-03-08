package com.learn_everyday.learn_aop.learn_aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// PointCut
	// @Around("execution(* com.learn_everyday.learn_aop.learn_aop.business.*.*(..))")
//	@Around("com.learn_everyday.learn_aop.learn_aop.aspect.CommonJointPointConfiguration.businessLayerExecution()")
	@Around("com.learn_everyday.learn_aop.learn_aop.aspect.CommonJointPointConfiguration.trackTimeAnnotation()")
	public void beforeAspect(ProceedingJoinPoint joinpoint) throws Throwable {
		// Advice
		long statTime = System.currentTimeMillis();
		joinpoint.proceed();
		long timeTaken = System.currentTimeMillis() - statTime;
		logger.info("Time taken by {} is {}", joinpoint, timeTaken);
	}

}
