package com.sunil.sources.aop.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLogger {
	
	private Logger log = Logger.getLogger(AppLogger.class);
	
	@Before(value="(execution(* com.sunil..*.*(..)))")
	public void beforeCallingMethod(JoinPoint jp) {
		log.info("START: " + jp);
		for(Object ar: jp.getArgs()) {
			log.info("Argument Received: " + ar.toString() );
		}
	}
	
	@After(value="(execution(* com.sunil..*.*(..)))")
	public void afterCallingMethod(JoinPoint jp) {
		log.info("END: " + jp);
	}
	
}
