package com.kong.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")              // 开放所有的请求地址
                .allowedOriginPatterns("*")                // 允许的来源
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(CorsConfiguration.ALL)     // 允许所有的请求方式
                .allowCredentials(true)                    // 允许前端带上凭证信息，比如带上他的cookie信息，常见的登录操作
                .maxAge(3600);                             // 1小时内不需要再预检（发OPTIONS请求）
    }

}