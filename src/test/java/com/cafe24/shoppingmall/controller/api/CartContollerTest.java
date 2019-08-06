package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.google.gson.Gson;

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
	public void testDICartService() {
		assertNotNull(cartService);
	}

	@Ignore
	@Test
	public void addCartTest() throws Exception {
		
		CartVo cartVo = new CartVo();
		cartVo.setAmount(10);
		cartVo.setDisplayedProductNo(1L);
		cartVo.setUserId("hgdkk");
		
		ResultActions resultActions = mockMvc.perform(
				post("/cart").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(cartVo)));
		
		resultActions.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.result", is("success")))
				.andExpect(jsonPath("$.data", is(true)));
	}
	
//	@Ignore
	@Test
	public void getCartListTest() throws Exception {
		
		ResultActions resultActions = mockMvc.perform(
				get("/cart/list/{userId}", "hgdkk")
				.contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}
	
}
