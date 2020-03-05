package com.kuang.config;

import com.kuang.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 代表这是一个配置类
public class MyMvcConfig implements WebMvcConfigurer {

    // 通过配置类来设置视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 选择要过滤和排除的请求
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login")
                .excludePathPatterns("/asserts/**");
    }
}
