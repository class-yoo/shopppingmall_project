package com.cafe24.shoppingmall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.app.AppSecurityConfig;
import com.cafe24.config.app.AuthorizationServerConfig;
import com.cafe24.config.app.DBConfig;
import com.cafe24.config.app.MyBatisConfig;
import com.cafe24.config.app.ResourceServerConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shoppingmall.service", "com.cafe24.shoppingmall.repository", "com.cafe24.shoppingmall.aspect",
	"com.cafe24.shoppingmall.security"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {
	
}