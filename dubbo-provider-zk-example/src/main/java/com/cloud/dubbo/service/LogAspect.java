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
        Object[] args = joinPoint.getArgs();
        log.error("args = {}", Arrays.toString(args));
        AbstractBaseReq abstractBaseReq = (AbstractBaseReq) args[0];
        String threadId = abstractBaseReq.getThreadId();
        log.error("threadId = {}", threadId);
        MDC.clear();
        MDC.put("threadId", threadId);

    }
}
