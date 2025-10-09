package com.grid.CrudOperation.aspect;

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
    @Before("execution(* com.grid.CrudOperation.controller.SampleCRUDController.getAllNames())")
    public void logBeforeMethod() {
        logger.info("Before method execution");
    }

    //logging after the specific method call
    @After("execution(* com.grid.CrudOperation.controller.SampleCRUDController.getAllNames())")
    public void logAfterMethod() {
        logger.info("After method execution");
    }

    //using ProceedingJoinPoint as it has control over execution missing with JoinPoint, it cant control.
    @Around("execution (* com.grid.CrudOperation.controller.SampleCRUDController.getAllNames())")
    public Object logAtAnyPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Input arguments at method start :" + proceedingJoinPoint.getArgs());

        Object result = proceedingJoinPoint.proceed();

        logger.info("At the end of the method :");
        return result;
    }

    //logging the retun object using @AfterReturning
    @AfterReturning(pointcut = "execution (* com.grid.CrudOperation.controller.SampleCRUDController.getAllNames())", returning = "result")
    public void afterReturningAdvice(Object result) {
        logger.info("Returning object :" + result);
    }

    //logging the Exception object thrown
    @AfterThrowing(pointcut = "execution (* com.grid.CrudOperation.controller.SampleCRUDController.getAllNames())", throwing = "ex")
    public void afterReturningAdvice(Exception ex) {
        logger.info("<<>>Exception :" + ex);
    }

}
