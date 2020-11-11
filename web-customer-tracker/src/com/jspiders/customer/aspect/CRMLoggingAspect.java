package com.jspiders.customer.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.jspiders.customer.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.jspiders.customer.service*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.jspiders.customer.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint join) {
		String shortString = join.getSignature().toShortString();
		myLogger.info("@Before " + shortString);
		Object[] args = join.getArgs();
		for (Object object : args) {
			myLogger.info("====> args: " + object);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "res")
	public void afterReturning(JoinPoint join, Object res) {
		String shortString = join.getSignature().toShortString();
		myLogger.info("@AfterReturning" + shortString);
		myLogger.info("result" + res);
	}
}
