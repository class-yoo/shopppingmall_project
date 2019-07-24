package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, WebConfig.class })
@WebAppConfiguration
public class ProductControllerTest {
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ProductService productService;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	public void testDIOrderService() {
		assertNotNull(productService);
	}
	
	@Ignore
	@Test
	public void addProductTest() throws Exception {

		ProductVo productVo = new ProductVo();
		productVo.setCode("P001PKT78");
		productVo.setName("슬라브티셔츠");
		productVo.setMaterial("나일론 100%");
		productVo.setDescription("##%#%%#");
		productVo.setDetailDescription("detail!@#!#!@");
		productVo.setSupplyPrice(43000);
		productVo.setConsumerPrice(25000);
		productVo.setManufacturer("나이스");
		productVo.setSupplier("나이스");
		productVo.setHome("미국");
		productVo.setManufactureDate("2019-07-21");
		productVo.setRestockCheck("N");
		productVo.setPurchaseCount(126L);
		productVo.setDisplayCheck("Y");
		productVo.setSaleCheck("Y");
		productVo.setHits(219L);
		productVo.setPreferenceScore(9);
		productVo.setPostPriority(0);
		productVo.setCategoryNo(1L);
		
		ResultActions resultActions = mockMvc
				.perform(post("/product/add", productVo)
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(productVo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")));
		
	}
	
//	@Ignore
	@Test
	public void getProductTest() throws Exception {

		Long productNo = 1L;

		ResultActions resultActions = mockMvc
				.perform(get("/product/{productNo}", productNo).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")));
		
	}
}
