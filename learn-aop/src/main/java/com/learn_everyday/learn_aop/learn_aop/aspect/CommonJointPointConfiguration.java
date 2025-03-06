package com.learn_everyday.learn_aop.learn_aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJointPointConfiguration {

	@Pointcut("execution(* com.learn_everyday.learn_aop.learn_aop.data.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("execution(* com.learn_everyday.learn_aop.learn_aop.business.*.*(..))")
	public void businessLayerExecution() {}
}
