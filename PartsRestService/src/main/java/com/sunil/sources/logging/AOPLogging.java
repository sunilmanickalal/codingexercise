package com.sunil.sources.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLogging {

	@Before("execution(* com.sunil..*.*(..))")
	public void beforeMethodExecution(JoinPoint jp) {
		System.out.println("======START: " + jp );
	}
	
	@After("execution(* com.sunil..*.*(..))")
	public void AfterMethodExecution(JoinPoint jp) {
		System.out.println("=======END: " + jp );
	}
	
	
//	@Before("execution(* com.sunil..*.*(..)) && args(..)")
//	public void BeforeCallingMethod(JoinPoint jp) {
//		System.out.println("=========START: " + jp );
//	}
//	
//	@After("execution(* com.sunil..*.*(..)) && args(..)")
//	public void AfterCallingMethod(JoinPoint jp) {
//		System.out.println("=========END: " + jp);
//	}
//	
//	@AfterReturning("execution(* com.sunil..*.*(..)) && args(..)")
//    public void AfterReturningFromMethod(JoinPoint joinPoint) {
//        System.out.println("========Completed: " + joinPoint);
//    }
	
//	@Around("execution(* com.sunil..*.*(..)) && args(..)")
//    public void AroundMethod(JoinPoint joinPoint) {
//        System.out.println("========Around: " + joinPoint + " *****");
//    }
	
	
}
