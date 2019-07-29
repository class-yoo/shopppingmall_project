package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.DisplayedProductVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductImage;
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
		productVo.setNo(13L);
		productVo.setCode("P001PHG");
		productVo.setName("댄디자켓");
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
		
		
		List<DisplayedProductVo> displayedProducts = new ArrayList<DisplayedProductVo>();
		displayedProducts.add(new DisplayedProductVo(null, "fdsfdsf123","댄디자켓", "블랙/M", "d:/top/jacket/abc.jpg", 200, 
				"N", 0, 52000, null));
		List<OptionVo> options = new ArrayList<OptionVo>();
		options.add(new OptionVo(null, "PHG", "색상", "블랙/화이트/오트밀", null));
		List<ProductImage> productImages = new ArrayList<ProductImage>();
		productImages.add(new ProductImage(null, "d:/top/jacket/abc.jpg", "Y", null));
		
		productVo.setDisplayedProducts(displayedProducts);
		productVo.setOptions(options);
		productVo.setProductImages(productImages);
		
		ResultActions resultActions = mockMvc
				.perform(post("/product/add", productVo)
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(productVo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")));
		
	}
	
	@Ignore
	@Test
	public void modifyProductTest() throws Exception {

		ProductVo productVo = new ProductVo();
		productVo.setNo(38L);
		productVo.setCode("P001TBT");
		productVo.setName("투버튼자켓");
		productVo.setMaterial("캐시미어 100%");
		productVo.setDescription("!@#@!#@!");
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
				.perform(put("/product/modify", productVo)
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(productVo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")));
		
	}
	
	@Test
	public void getProductListTest() throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("keyword", "");
		map.put("category", 0);
		map.put("curpageNum", 1);
		map.put("showProductNum", 10);
		
		ResultActions resultActions = mockMvc
				.perform(post("/product/list")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(map)));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));

	}
	
	
	
	@Ignore
	@Test
	public void getProductTest() throws Exception {

		Long productNo = 1L;
		
		ResultActions resultActions = mockMvc
				.perform(get("/product/{productNo}", productNo).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));

	}
	
	@Ignore
	@Test
	public void removeProductTest() throws Exception {

		Long productNo = 41L;
		ResultActions resultActions = mockMvc
				.perform(delete("/product/remove/{productNo}", productNo).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));

	}
}
