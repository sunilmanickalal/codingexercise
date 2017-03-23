package com.sunil.sources.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLogger {

	private Logger log = Logger.getLogger(AOPLogger.class);
	
	@Before("execution(* com.sunil..*.*(..))")
	public void beforeMethodCall(JoinPoint jp) {
		log.info("START: " + jp.getSignature());
		for(Object arg: jp.getArgs()){
			log.info("Arguments Passed: " + arg);
		}
	}
	
	@After("execution(* com.sunil..*.*(..))")
	public void afterMethodCall(JoinPoint jp) {
		log.info("END: " + jp.getSignature());
		log.info("Returned value: " + jp.getTarget().toString());
	}
	
}
