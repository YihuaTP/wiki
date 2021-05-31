package com.kong.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

//    // 注入这个拦截器
//    @Resource
//    InterfaceTimeInterceptor interfaceTimeInterceptor;
//
//    // 对拦截器进行一些配置，计算接口时间的直接默认权限路由
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interfaceTimeInterceptor)
//                .addPathPatterns("/**");                     // 那些接口需要经过这个拦截器
//    }

}
