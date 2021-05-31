package com.kong.wiki.interceptor;

import com.kong.wiki.filter.InterfaceTimeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器：Spring框架特有的，常用于登录校验，权限校验，请求日志打印
 * 使用拦截器结算接口耗时
 */
@Component
public class InterfaceTimeInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(InterfaceTimeInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 打印请求信息
        log.info("------------- 开始：接口开始被调用 -------------");
        log.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
        log.info("远程地址: {}", request.getRemoteAddr());

        long startTime = System.currentTimeMillis();
        request.setAttribute("requestStartTime", startTime);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("requestStartTime");
        log.info("------------- 结束：接口耗时：{} ms -------------", System.currentTimeMillis() - startTime);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
