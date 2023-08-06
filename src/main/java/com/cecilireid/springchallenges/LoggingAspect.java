package com.cecilireid.springchallenges;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Around("execution(* com.cecilireid.springchallenges.cateringJobController.*ById(Long)) && args(id)")
    public Object logObjects(ProceedingJoinPoint j, long id) throws Throwable{
        logger.info("Id: " + id);
        Object result = j.proceed();
        logger.info("Result: " + result.toString());
        return result;
    }
}
