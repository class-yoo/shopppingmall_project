package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;
import com.cafe24.shoppingmall.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, WebConfig.class })
@WebAppConfiguration
public class CartContollerTest {
	
	private MockMvc mockMvc;
	TestMockSession tms;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private CartService cartService;
	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		tms = new TestMockSession();
	}
	
	@Ignore
	@Test
	public void testDIUserService() {
		assertNotNull(cartService);
	}

	@Test
	public void putCartTest() throws Exception {
		
		CartVo cartVo = new CartVo();
		cartVo.setAmount(2);
		cartVo.setDisplayedProductNo(13L);
		
		UserVo userVo = new UserVo();
		userVo.setId("hgd888");
		userVo.setName("홍길동");
		tms.setMockSession(null);
		
		ResultActions resultActions = mockMvc.perform(
				post("/api/cart/put")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(cartVo))
				.session(tms.getMockSession()));

		resultActions.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.result", is("success")))
				.andExpect(jsonPath("$.data", is(true)));
	}

}
