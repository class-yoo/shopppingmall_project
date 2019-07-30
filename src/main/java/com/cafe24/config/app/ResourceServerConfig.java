package com.cafe24.config.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();

		// 자원 서버 접근 권한 설정
		http
			.authorizeRequests()
			.antMatchers("/cart/**").access("#oauth2.hasScope('MALL_USER')")
			.antMatchers("/hello2").access("#oauth2.hasScope('MALL_USER')");
	}
}