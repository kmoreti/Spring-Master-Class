package com.moreti.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.moreti.spring.aop.springaop.data.*.*(..))")
	public void dataLayerExecution() {}

	@Pointcut("execution(* com.moreti.spring.aop.springaop.business.*.*(..))")
	public void businessLayerExecution() {}

	@Pointcut("com.moreti.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()"
			+ "&& com.moreti.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void anyLayerExecution() {}

	@Pointcut("bean(Dao*)")
	public void beanStartWithDao() {	}

	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {}
	
	@Pointcut("within(com.moreti.spring.aop.springaop.data..*)")
	public void dataLayerExecutionWithWithin() {}
	
	@Pointcut("@annotation(com.moreti.spring.aop.springaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {}
}