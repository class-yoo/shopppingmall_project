package com.cafe24.config.web;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cafe24.shoppingmall.security.AuthInterceptor;
import com.cafe24.shoppingmall.security.AuthLoginInterceptor;
import com.cafe24.shoppingmall.security.AuthLogoutInterceptor;
import com.cafe24.shoppingmall.security.AuthUserHandlerMethodArgumentResolver;


@Configuration
public class SecurityConfig extends WebMvcConfigurerAdapter {
	//
	//	Argument Resolver
	//
	@Bean
	public AuthUserHandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver() {
		return new AuthUserHandlerMethodArgumentResolver();
	}
	
	@Override 
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(authUserHandlerMethodArgumentResolver());
	}
	
	@Bean
	public AuthLoginInterceptor authLoginInterceptor() {
		return new AuthLoginInterceptor();
	}
	
	@Bean
	public AuthLogoutInterceptor authLogoutInterceptor() {
		return new AuthLogoutInterceptor();
	}
	
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	
	//
	//	InterCeptor
	//
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry
		.addInterceptor(authLoginInterceptor())
		.addPathPatterns("/user/auth");
	}
	
}
