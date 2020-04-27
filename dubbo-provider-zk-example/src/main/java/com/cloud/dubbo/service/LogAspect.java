package com.cloud.dubbo.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wcy
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.cloud.dubbo.service..*Provider.*(..))")
    public void pointcut() {

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        final String threadId = MDC.get("threadId");
        Object[] args = joinPoint.getArgs();
//        args[0] = threadId;

        log.error("args = {}", Arrays.toString(args));


    }
}
