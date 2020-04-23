package com.cloud.dubbo.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wcy
 * @date 2019/7/10 16:51
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private ThreadLocal<StopWatch> swThread = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        StopWatch sw = new StopWatch();
        swThread.set(sw);
        sw.start();
        MDC.clear();
        MDC.put("threadId", UUID.randomUUID().toString().replaceAll("-",""));

        Map<String, String> map = new HashMap<>(64);
        Enumeration<String> parameterNames = request.getParameterNames();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            map.put(name, request.getHeader(name));
        }
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            map.put(name, request.getParameter(name));
        }
        String token = request.getHeader("token");
        log.info("token:{}" , token);
        log.info("请求路径: {}" , request.getRequestURI());
        log.info("请求参数: {}" , JSON.toJSONString(map));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        swThread.get().stop();
        swThread.get().start();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        StopWatch sw = swThread.get();
        sw.stop();
        String method = handler.getClass().getSimpleName();
        if (handler instanceof HandlerMethod) {
            String beanType = ((HandlerMethod) handler).getBeanType().getName();
            String methodName = ((HandlerMethod) handler).getMethod().getName();
            method = beanType + "." + methodName;
        }

        log.info("METHOD = {}; STATUS = {}; EX = {}; 总时间 = {}ms; 完成时间 = {}ms; 前置时间 = {}ms",
                method,
                response.getStatus(),
                ex == null ? "-" : ex.getClass().getSimpleName(),
                sw.getTotalTimeMillis(),
                sw.getTotalTimeMillis() - sw.getLastTaskTimeMillis(),
                sw.getLastTaskTimeMillis());
        swThread.remove();
    }
}
