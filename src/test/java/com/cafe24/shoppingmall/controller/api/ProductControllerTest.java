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
import java.util.Arrays;
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
import org.springframework.web.filter.CharacterEncodingFilter;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.DisplayedProductVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductImage;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
		CharacterEncodingFilter cef = new CharacterEncodingFilter();
		cef.setEncoding("utf-8");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.addFilters(cef).build();
	}

	@Ignore
	@Test
	public void testDIOrderService() {
		assertNotNull(productService);
	}

	@Ignore
	@Test
	public void addProductTest() throws Exception {
		
		// ProductVo 객체생성 및 데이터 세팅
		ProductVo productVo = new ProductVo();
		productVo.setNo(13L);
		productVo.setCode("P001PHG");
		productVo.setName("댄디자켓");
		productVo.setCompleteCategory("상의/자켓");
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
		
		// 사전에 저장된 카테고리를 선택한 다음에 상품을 등록하기 때문에 카테고리 목록보기 api를 호출한다.
		ResultActions categoryResult = mockMvc.perform(get("/category/list", productVo)
				.contentType(MediaType.APPLICATION_JSON));
		
		// 카테고리 목록보기 api의 호출결과를 Gson을 통해 원하는 데이터를 추출한다.
		String resultString = categoryResult.andReturn().getResponse().getContentAsString();
		
		// json을 Obejct 형태로 변경하기 위한 Gson 객체생성 
		Gson gson = new Gson();
		
		// 결과가 직접 선언한 JSONResult 클래스 형태의 Json String이기 때문에 JSONResult형태의 객체로 변환한다. 
		JSONResult jsonResult = gson.fromJson(resultString, JSONResult.class);
		
		// 카테고리형태의 List중 0번째 index에 해당하는 카테고리의 번호를 선택했다고 가정한 후, ProductVo에 저장한다.
		List<CategoryVo> list = gson.fromJson(gson.toJson(jsonResult.getData()),
				new TypeToken<List<CategoryVo>>() {}.getType());
		productVo.setCategoryNo(list.get(0).getNo());
		
		// 상품을 등록할때에는 진열상품, 옵션, 이미지 리스트도 같이 저장이 되기때문에 ProductVo 객체에 필요한 데이터를 저장한다.
		List<DisplayedProductVo> displayedProducts = new ArrayList<DisplayedProductVo>();
		displayedProducts.add(new DisplayedProductVo(null, "fdsfdsf123", "댄디자켓", "블랙/M", "d:/top/jacket/abc.jpg", 200,
				"N", 0, 52000, null));
		List<OptionVo> options = new ArrayList<OptionVo>();
		options.add(new OptionVo(null, "PHG", "색상", "블랙/화이트/오트밀", null));
		List<ProductImage> productImages = new ArrayList<ProductImage>();
		productImages.add(new ProductImage(null, "d:/top/jacket/abc.jpg", "Y", null));
		
		productVo.setDisplayedProducts(displayedProducts);
		productVo.setOptions(options);
		productVo.setProductImages(productImages);
		
		// POST 방식의 상품추가하기 API를 호출한다.
		ResultActions resultActions = mockMvc.perform(post("/product", productVo)
				.contentType(MediaType.APPLICATION_JSON).content(gson.toJson(productVo)));
		
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));

	}

	@Ignore
	@Test
	public void modifyProductTest() throws Exception {
		
		// ProductVo에 수정할 데이터 세팅
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

		// PUT 방식의 상품수정하기 API를 호출한다.
		ResultActions resultActions = mockMvc.perform(put("/product", productVo).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(productVo)));
		
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));
	}
	
	@Test
	public void getProductListTest() throws Exception {
		// 검색 조건에서 필요한 데이터 세팅
		String keyword = "댄디";
		Long categoryNoLong = 0L;
		int curPageNum = 1;
		int showProductNum = 5;
		
		// GET 방식의 상품목록보기 API를 호출한다.
		ResultActions resultActions = mockMvc
				.perform(get("/product/list/{keyword}/{categoryNo}/{curPageNum}/{showProductNum}",
						keyword, categoryNoLong, curPageNum, showProductNum)
						.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));
		
	}

	@Ignore
	@Test
	public void getProductTest() throws Exception {
		
		// 상세보기를 할 상품번호 세팅
		Long productNo = 1L;

		// GET 방식의 상품삭제하기 API를 호출한다.
		ResultActions resultActions = mockMvc
				.perform(get("/product/{productNo}", productNo).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));

	}
	
	@Ignore
	@Test
	public void removeProductTest() throws Exception {
		// 삭제할 상품번호 세팅
		Long productNo = 41L;
		
		// DELETE 방식의 상품상세보기 API를 호출한다.
		ResultActions resultActions = mockMvc
				.perform(delete("/product/{productNo}", productNo).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));

	}
}
