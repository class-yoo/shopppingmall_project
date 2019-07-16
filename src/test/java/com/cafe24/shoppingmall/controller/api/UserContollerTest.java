package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;
import com.cafe24.shoppingmall.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, WebConfig.class })
@WebAppConfiguration
public class UserContollerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UserService userService;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	public void testDIUserService() {
		assertNotNull(userService);
	}
	
	@Ignore
	@Test
	public void checkOverlapIdTest() throws Exception {
		ResultActions resultActions = mockMvc
						.perform(get("/api/user/checkid/{id}", "abcd")
						.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.result", is("fail")));
	}
	

	@Test
	public void joinTest() throws Exception {
		UserVo userVo = new UserVo();
		userVo.setId("hgda");
		userVo.setName("홍길동");
		userVo.setPassword("1234aaaa@@");
		userVo.setGender("M");
		userVo.setBirth("2019-07-29");
		userVo.setContact("010-0000-0000");
		userVo.setEmail("hgd888@cafe24.com");
		
		ResultActions resultActions = mockMvc
						.perform(post("/api/user/join")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(userVo)));

		resultActions.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)));
	}
	
	@Ignore
	@Test
	public void loginTest() throws Exception {
		UserVo userVo = new UserVo();
		userVo.setId("hgd888");
		userVo.setPassword("1234");
		
		ResultActions resultActions = mockMvc
						.perform(post("/api/user/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(userVo)));
		
		resultActions.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is("loginSuccess")));
	}
	
}
