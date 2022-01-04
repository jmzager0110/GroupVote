package com.liftoff.soloproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//added from java-web-dev-techjobs-authentication
@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    @Bean
    public  AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) authenticationFilter());
    }


}
