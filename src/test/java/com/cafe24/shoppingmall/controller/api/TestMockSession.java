package com.cafe24.shoppingmall.controller.api;

import javax.servlet.http.HttpSession;

import org.mockito.Mock;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.vo.UserVo;

public class TestMockSession {

	private static HttpSession session;

	public TestMockSession() {
		session = new MockHttpSession();
	}

	public void setMockSession(UserVo userVo) {
		if(userVo !=null) {
			session.setAttribute("authUser", userVo);
		}
	}

	public MockHttpSession getMockSession() {
		return (MockHttpSession)session;
	}

}
