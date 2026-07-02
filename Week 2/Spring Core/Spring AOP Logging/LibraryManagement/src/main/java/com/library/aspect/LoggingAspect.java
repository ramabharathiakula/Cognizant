package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("AOP Log: Before executing method -> "
                + joinPoint.getSignature().getName());
    }
}