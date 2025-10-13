package com.grid.crudoperation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    public final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //logging before at specific method call
    @Before("execution(* com.grid.crudoperation.controller.SampleCRUDController.getAllNames())")
    public void logBeforeMethod() {
        logger.info("Before method execution");
    }

    //logging after the specific method call
    @After("execution(* com.grid.crudoperation.controller.SampleCRUDController.getAllNames())")
    public void logAfterMethod() {
        logger.info("After method execution");
    }

    //using ProceedingJoinPoint as it has control over execution missing with JoinPoint, it cant control.
    @Around("execution (* com.grid.crudoperation.controller.SampleCRUDController.getAllNames())")
    public Object loggingAtSpecificMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        logger.info("Input arguments at method start : {}", proceedingJoinPoint.getArgs());

        Object result = proceedingJoinPoint.proceed();

        logger.info("At the end of the method :");
        Long endTime = System.currentTimeMillis();
        logger.info("Total execution time {}", (endTime - startTime));

        return result;
    }

    //logging the retun object using @AfterReturning
    @AfterReturning(pointcut = "execution (* com.grid.crudoperation.controller.SampleCRUDController.getAllNames())", returning = "result")
    public void afterReturningAdvice(Object result) {
        logger.info("Returning object : {}", result);
    }

    //logging the Exception object thrown
    @AfterThrowing(pointcut = "execution (* com.grid.crudoperation.controller.SampleCRUDController.getAllNames())", throwing = "ex")
    public void afterReturningAdvice(Exception ex) {
        logger.info("Exception : %s", ex);
    }

    //Logging everymethod inside a class
/*
    @Around("execution (* com.grid.CrudOperation.controller.SampleCRUDController.*(..))")
    public Object loggingEveryMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Long startTime = System.currentTimeMillis();
        logger.info("Input arguments at method start : {}" , proceedingJoinPoint.getArgs());
        Object result = proceedingJoinPoint.proceed();
        logger.info("At the end of the method :");
        Long endTime = System.currentTimeMillis();
        logger.info("Total execution time {}" , (endTime - startTime));

        return result;
    }
*/

    //Custom annoatation for method logs
    @Around("@annotation (com.grid.crudoperation.customAnnotation.LogUsingAnnaotation)")
    public Object logUsingAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Long startTime = System.currentTimeMillis();
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        logger.info("Start of the method : {}", methodName);

        Object result = proceedingJoinPoint.proceed();

        Long endTime = System.currentTimeMillis();
        logger.info("Time taken for method execution {} is {} ms", methodName, (endTime - startTime));

        return result;
    }

}
