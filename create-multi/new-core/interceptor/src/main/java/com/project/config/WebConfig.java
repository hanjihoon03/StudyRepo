package com.project.config;

import com.project.argumentResolver.LoginUserArgumentResolver;
import com.project.interceptor.AdminInterceptor;
import com.project.interceptor.LogInterceptor;
import com.project.interceptor.LoginCheckInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.List;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/*.ico","/error","/actuator/**");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(3)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login/**","logout","/images/**","/actuator/**","/log",
                        "/css/**","/js/**","/*.ico","/error/**", "/sign-up","/bookList","/admin/**","/adminPage","/ioError",
                        "/clothesList","/electronicsList","/foodList","/purchase/**","/api/**","/swagger-ui/**","/deleteItem/**"
                );
        registry.addInterceptor(new AdminInterceptor())
                .order(2)
                .addPathPatterns("/admin/*");

    }

}
