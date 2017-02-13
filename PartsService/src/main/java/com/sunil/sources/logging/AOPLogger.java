package com.sunil.sources.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLogger {

	@Before("execution(* com.sunil..*.*(..))")
	public void BeforeMethodExecution(JoinPoint jp) {
		System.out.println("START: " + jp);
	}
	
	@AfterReturning("execution(* com.sunil..*.*(..))")
	public void AfterMethodExecution(JoinPoint jp) {
		System.out.println("END: " + jp);
	}
	
}
