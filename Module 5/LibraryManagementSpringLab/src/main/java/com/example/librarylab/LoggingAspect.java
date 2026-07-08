package com.example.librarylab;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.librarylab.LibraryService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Logging before: " + joinPoint.getSignature().getName());
    }
}
