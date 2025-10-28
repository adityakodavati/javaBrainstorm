package com.grid.CrudOperation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    public final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(com.grid.CrudOperation.CustomAnnotation.LoggingMethodUsingCustomAnnotation)")
    public Object logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName =  proceedingJoinPoint.getSignature().toShortString();
        Long startTime = System.currentTimeMillis();

        logger.info("before method call :" + methodName);

        Object result = proceedingJoinPoint.proceed();

        Long endTime = System.currentTimeMillis();
        logger.info("Execution time for {} is : {}" , methodName , (endTime-startTime));
        return result;
    }

}
