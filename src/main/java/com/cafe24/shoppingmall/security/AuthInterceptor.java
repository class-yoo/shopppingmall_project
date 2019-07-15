package com.cafe24.shoppingmall.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.shoppingmall.vo.UserVo;


public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (handler instanceof HandlerMethod == false) {
			System.out.println(handler);
			return true;
		}
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

		if (auth == null) {
			return true;
		}
		
		// 인증 여부 체크
		HttpSession session = request.getSession();
		if (session == null) { // 인증이 안되어 있음
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		if (authUser == null) { // 인증이 안되어 있음
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		Auth.Role role = auth.role();
		
		if(role == Auth.Role.USER) {
			return true;
		}
		
		return false;
	}

}
