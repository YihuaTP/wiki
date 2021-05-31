package com.kong.wiki.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 使用filter打印接口消耗时间
 */
// @Component，使用拦截器了，直接注释注解，让Spring扫描不到就行了
public class InterfaceTimeFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(InterfaceTimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 拿到请求，获取到想要的信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        log.info("------------- 开始：接口开始被调用 -------------");
        log.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
        log.info("远程地址: {}", request.getRemoteAddr());
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);     // 执行过滤器的链路，最后返回来，计算接口耗时
        log.info("------------- 结束：接口耗时：{} ms -------------", System.currentTimeMillis() - startTime);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
