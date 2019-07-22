package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.OrderProductVo;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.google.gson.Gson;
import com.cafe24.shoppingmall.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, WebConfig.class })
@WebAppConfiguration
public class OrderContollerTest {
	
	private MockMvc mockMvc;
	TestMockSession tms;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private OrderService orderService;
	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		tms = new TestMockSession();
	}
	
	@Ignore
	@Test
	public void testDIOrderService() {
		assertNotNull(orderService);
	}

	
	@Ignore
	@Test
	public void putOrderTest() throws Exception {
		
		OrderVo orderVo = new OrderVo();
		orderVo.setNo(5L);
		orderVo.setOrderNo("ASD123215");
		orderVo.setTitle("절개나시티 외 3개의 상품");
		orderVo.setDescription("절개나시티및  반팔티 청바지등");
		orderVo.setDestination("서울시 관악구 봉천로 13길 1");
		orderVo.setDetailAddress("105동 2103호");
		orderVo.setPostalCode("380-1231");
		orderVo.setRequirement("빠른배송 부탁드립니다.");
		orderVo.setPhoneNumber("010-7754-3213");
		orderVo.setContact("010-7653-1141");
		orderVo.setEmail("abc@naver.com");
		orderVo.setPassword("주문123");
		orderVo.setOrderStatus("주문");
		orderVo.setDeliverStatus("배송준비중");
		orderVo.setOrderDate("2019-07-18");
		orderVo.setRefundBank("기업은행");
		orderVo.setRefundAccount("11085631432");
		orderVo.setTotalPrice(78500);
		orderVo.setDeliverNumber("GYTD19434222AE");
		orderVo.setTrackingNumber("S704549545123");
		orderVo.setUserId("hgdkkk");
		
		OrderProductVo orderProductVo = new OrderProductVo();
		orderProductVo.setAmount(2);
		orderProductVo.setPrice(50000);
		orderProductVo.setDisplayedProductNo(1L);
		orderProductVo.setOrderNo(orderVo.getNo());
		OrderProductVo orderProductVo2 = new OrderProductVo();
		orderProductVo2.setAmount(1);
		orderProductVo2.setPrice(38000);
		orderProductVo2.setDisplayedProductNo(2L);
		orderProductVo2.setOrderNo(orderVo.getNo());
		
		List<OrderProductVo> orderProductVos = new ArrayList<OrderProductVo>();
		
		orderProductVos.add(orderProductVo);	
		orderProductVos.add(orderProductVo2);
		orderVo.setOrderProductVos(orderProductVos);
		
		ResultActions resultActions = mockMvc.perform(
				post("/order/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(orderVo)));
		
		resultActions.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}
	
//	@Ignore
	@Test
	public void getOrderListTest() throws Exception {
		
		String userId = "hgdkkk";
		
		ResultActions resultActions = mockMvc.perform(
				get("/order/list/{userId}", userId)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}
	
	@Ignore
	@Test
	public void getOrderDetailTest() throws Exception {
		
		Long orderNo = 1L;
		
		ResultActions resultActions = mockMvc.perform(
				post("/order/list/{orderNo}", orderNo)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}
}
