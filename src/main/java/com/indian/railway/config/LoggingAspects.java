package com.indian.railway.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class LoggingAspects {

    @Before("execution(* com.indian.railway.service.impl.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before method : {} ",joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.indian.railway.service.impl*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint) {
        log.info("After method: {}", joinPoint.getSignature().getName());
    }


}
