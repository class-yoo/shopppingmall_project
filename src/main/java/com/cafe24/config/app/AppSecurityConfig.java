package com.cafe24.config.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.cafe24.shoppingmall.security.CustomUrlAuthenticationSuccessHandler;

/*Security Filter Chain
 
 V 표시는 DelegatingFilterProxy에 꼭 설정해야하는 Filter
 
	 1. ChannelProcessingFilter
	 2. SecurityContextPersistenceFilter		( auto-config default 	, V) ACL 없을때 기본적으로 URL 차단해주는역할 ? 
	 3. ConcurrentSessionFilter
	 4. LogoutFilter							( auto-config default	, V)
	 5. UsernamePasswordAuthenticationFilter	( auto-config default 	, V)
	 6. DefaultLoginPageGeneratingFilter		( auto-config default )
	 7. CasAuthenticationFilter
	 8. BasicAuthenticationFilter				( auto-config default )
	 9. RequestCacheAwareFilter					( auto-config default )
	10. SecurityContextHolderAwareRequestFilter	( aut	o-config default )
	11. JaasApiIntegrationFilter
	12. RememberMeAuthenticationFilter			(Custom Filter로 설정해줘야됨 , V)
	13. AnonymousAuthenticationFilter			( auto-config default )
	14. SessionManagementFilter					( auto-config default 	, V)
	15. ExceptionTranslationFilter				( auto-config default 	, V )*/


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean(name="springSecurityFilterChain")
	public FilterChainProxy filterChainProxy() throws Exception {
		List<SecurityFilterChain> filterChains = new ArrayList<>();
		
		filterChains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/assets/**")));
		filterChains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/favicon.ico")));
		filterChains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"),
				//filter chains
				//1. securityContext
				securityContextPersistenceFilter(),
				
				//2. logout 
				logoutFilter(),
				
				//3. authentication
				usernamePasswordAuthenticationFilter(),
				
				//4. anonymous
				anonymousAuthenticationFilter(),
				
				//5. exception
				exceptionTranslationFilter(),
				
				//6. ACL
				filterSecurityInterceptor(),
				
				//7. remember-me
				rememberMeAuthenticationFilter()
				));
		
		return new FilterChainProxy(filterChains);
	}
	
	@Bean
	public SecurityContextPersistenceFilter securityContextPersistenceFilter() {
		return new SecurityContextPersistenceFilter(new HttpSessionSecurityContextRepository());
	}
	
	//CustomLogoutSuccessHandler >> API의 경우, 로그아웃 시 JSON 응답 처리
	@Bean
	public LogoutFilter logoutFilter() throws ServletException {
		CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler("JSESSIONID");
		SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler(); 
		securityContextLogoutHandler.setInvalidateHttpSession(true);
		securityContextLogoutHandler.setClearAuthentication(true);
		
		//CookieClearing
		LogoutFilter logoutFilter = new LogoutFilter("/", cookieClearingLogoutHandler, securityContextLogoutHandler);
		logoutFilter.setFilterProcessesUrl("/api/member/logout");
		logoutFilter.afterPropertiesSet();
		
		return logoutFilter;
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomUrlAuthenticationSuccessHandler();
	}
	
	@Bean
	public AbstractAuthenticationProcessingFilter usernamePasswordAuthenticationFilter() {
		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter =	new UsernamePasswordAuthenticationFilter();
		
		usernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
		usernamePasswordAuthenticationFilter.setUsernameParameter("id");
		usernamePasswordAuthenticationFilter.setPasswordParameter("password");
		usernamePasswordAuthenticationFilter.setFilterProcessesUrl("/api/member/auth");
		usernamePasswordAuthenticationFilter.setAllowSessionCreation(true);
		usernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
		usernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/member/login?result=fail"));
		
		return usernamePasswordAuthenticationFilter;
	}
	
	//인증 없는 사용자 처리
	@Bean
	public AnonymousAuthenticationFilter anonymousAuthenticationFilter() {
		//임의 key 값 발급
		return new AnonymousAuthenticationFilter("a1j2b3y4c5p6d");
	}
	
	//인증 or 권한이 없는 경우
	@Bean
	public ExceptionTranslationFilter exceptionTranslationFilter() {
		ExceptionTranslationFilter exceptionTranslationFilter = 
				new ExceptionTranslationFilter(new LoginUrlAuthenticationEntryPoint("/api/member/login"));
		
		AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
		accessDeniedHandler.setErrorPage("/WEB-INF/views/error/exception.jsp");
		
		exceptionTranslationFilter.setAccessDeniedHandler(accessDeniedHandler);
		exceptionTranslationFilter.afterPropertiesSet();
		
		return exceptionTranslationFilter;
	}
	
	@Bean
	public FilterSecurityInterceptor filterSecurityInterceptor() throws Exception {
		FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
		
		filterSecurityInterceptor.setAuthenticationManager(authenticationManager());
		filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager());
		
		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
		requestMap.put(new AntPathRequestMatcher("/api/member/update"), SecurityConfig.createList("isAuthenticated()"));
		requestMap.put(new AntPathRequestMatcher("/api/member/logout"), SecurityConfig.createList("isAuthenticated()"));
		
		requestMap.put(new AntPathRequestMatcher("/api/board/write"), SecurityConfig.createList("isAuthenticated()"));
		
		requestMap.put(new AntPathRequestMatcher("/api/admin/**"), SecurityConfig.createList("hasRole('ADMIN')"));
		
//		requestMap.put(new AntPathRequestMatcher("/**"), SecurityConfig.createList("permitAll"));
		
		
		FilterInvocationSecurityMetadataSource newSource = 
				new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, new DefaultWebSecurityExpressionHandler());
		
		filterSecurityInterceptor.setSecurityMetadataSource(newSource);
		
		return filterSecurityInterceptor;
	}
	
	//적용 X
	@Bean
	public RememberMeAuthenticationFilter rememberMeAuthenticationFilter() {
		TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("ypshop-backend", userDetailsService);
		rememberMeServices.setParameter("remember-me");
		
		RememberMeAuthenticationFilter rememberMeAuthenticationFilter = 
				new RememberMeAuthenticationFilter(authenticationManager(), rememberMeServices);
		
		return rememberMeAuthenticationFilter;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(authenticationProvider()));
		return authenticationManager;
	}
	
	//비밀번호 암호화 by BCrypt
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public AffirmativeBased accessDecisionManager() throws Exception {
		RoleVoter roleVoter = new RoleVoter();
		
		AffirmativeBased affirmativeBased = new AffirmativeBased(Arrays.asList(roleVoter, new WebExpressionVoter(), new AuthenticatedVoter()));
		affirmativeBased.setAllowIfAllAbstainDecisions(false);
		affirmativeBased.afterPropertiesSet();
		
		return affirmativeBased;
	}
	
}
