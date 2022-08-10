package com.epf.demo.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	/**
     * 自定义拦截器，添加拦截路径和排除拦截路径
     * addPathPatterns():添加需要拦截的路径
     * excludePathPatterns():添加不需要拦截的路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/user/**");
        list.add("/verify/**");
        list.add("/static/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(list);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
