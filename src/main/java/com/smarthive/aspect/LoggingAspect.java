package com.smarthive.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com.smarthive.service..*(..))")
	public void serviceMethods() {
	}

	@Before("serviceMethods()")
	public void before(JoinPoint jp) {
		System.out.println("Before -> " + jp.getSignature());
	}

	@After("serviceMethods()")
	public void after(JoinPoint jp) {
		System.out.println("📌 AFTER  → " + jp.getSignature());
	}

	@Around("serviceMethods()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("Around begin : " + pjp.getSignature());

		Object result = pjp.proceed();
		System.out.println("Around end : " + pjp.getSignature());

		return result;

	}

}