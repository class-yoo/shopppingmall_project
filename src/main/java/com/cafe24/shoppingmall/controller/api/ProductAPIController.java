package com.cafe24.shoppingmall.controller.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.util.Paging;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductImage;
import com.cafe24.shoppingmall.vo.ProductVo;

import io.swagger.annotations.ApiOperation;

@RestController("productAPIController")
@RequestMapping("/product")
public class ProductAPIController {
	
	@Autowired
	private ProductService productService;
	
	/** TODO Message - 상품추가하기
	  * 
	  * 저장 할 json 형태의 데이터를 상품객체인 ProductVo 타입의 파라미터로 받아서 사용한다.
	  * ProductVo 객체에는 진열상품객체의 리스트인  displayedProducts, 옵션객체 리스트인 options,
	  * 이미지 객체 리스트인 productImages 필드가 존재한다. 
	  * 해당리스트들은 productService 객체에서 각각 DB와 연결된 insert 메소드를 호출하여 저장된다. 
	  * */
	@ApiOperation(value = "상품추가하기")
	@RequestMapping(value="", method=RequestMethod.POST)
	public JSONResult add(@RequestBody ProductVo productVo) {
		boolean addResult = productService.add(productVo);
		
		System.out.println(productVo);
		
		return JSONResult.success(addResult);
	}
	
	
	/** TODO Message - 상품정보보기
	  * 
	  * 상세정보를 확인할 상품번호 productNo를 Long 형태의 파라미터로 받아서 사용한다.
	  * service 및 repository 구간의 메소드도 단순한 READ 형태의 메소드이며
	  * DB에서 SELECT할 때, 진열상품객체의 리스트인  displayedProducts, 옵션객체 리스트인 options,
	  * 이미지 객체 리스트인 productImages를 mybatis의 ResultMap 기능으로 함께 읽어온다.
	  * 
	  * */
	@ApiOperation(value = "상품정보보기")
	@RequestMapping(value="/{productNo}", method=RequestMethod.GET)
	public JSONResult get(@PathVariable Long productNo) {
		
		ProductVo productVo = productService.getProductByProductNo(productNo);
		
		return JSONResult.success(productVo);
	}
	
	
	/** TODO Message - 상품수정하기
	  * 
	  * json 형태의 데이터를 상품객체인 ProductVo 타입의 파라미터로 받아서 사용한다.
	  * service 및 repository 구간의 메소드도 단순한 UPDATE 형태의 메소드이다.  
	  * 
	  * */
	@ApiOperation(value = "상품수정하기")
	@RequestMapping(value="", method=RequestMethod.PUT)
	public JSONResult modify(@RequestBody ProductVo productVo) {
		boolean modifyResult = productService.modify(productVo);
		return JSONResult.success(modifyResult);
	}
	
	/** TODO Message - 상품삭제하기
	  * 
	  * 삭제 할 상품번호 productNo를 Long 형태의 파라미터로 받아서 사용한다.
	  * 상품이 삭제되면 그에 관련된 정보들이 삭제되어야 하기 때문에 service 구간에서 
	  * 옵션, 진열상품, 이미지를 삭제하는 메소드를 호출하여 모두삭제한다.
	  *   
	  * */
	@ApiOperation(value = "상품삭제하기")
	@RequestMapping(value="/{productNo}", method=RequestMethod.DELETE)
	public JSONResult remove(@PathVariable Long productNo) {
		boolean removeResult = productService.remove(productNo);
		return JSONResult.success(removeResult);
	}
	
	/** TODO Message - 상품목록보기
	  * 
	  * 검색 할 상품명에 포함되어있는 keyword, 카테고리번호인 categoryNo, 사용자가 클릭한 페이지번호인 curPageNum,
	  * 한페이지당 화면에 나타낼 상품의 개수인 showProductNum을 파라미터로 받아서 사용한다.
	  * 페이징 처리를 할 Paging 클래스를 이용하여 찾아올 상품들의 구간 및 개수를 설정한다.
	  * service 및 repository 구간의 메소드는 단순한 SELECT 형태의 메소드이다. 
	  * 보여줄 첫번째 상품의 인덱스와, 보여줄 개수를 인자로 넣어주면서 상품리스트를 찾아온다
	  * */
	@ApiOperation(value = "상품목록보기")
	@RequestMapping(value="/list/{keyword}/{categoryNo}/{curPageNum}/{showProductNum}", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> list(@PathVariable (value="keyword") String keyword,
			@PathVariable(value="categoryNo") Long categoryNo,
			@PathVariable(value="curPageNum") int curPageNum,
			@PathVariable(value="showProductNum") int showProductNum) {
		
		if("empty".equals(keyword)) keyword = "";
		
		Long productCount = productService.getProductCount(keyword, categoryNo);
		Paging paging = new Paging();
		paging.pagingSetting(productCount, showProductNum , curPageNum);
		
		List<ProductVo> list = productService.getSearchProductList(keyword, categoryNo, paging.getStartPageNum(), showProductNum);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}

	
	@ApiOperation(value = "상품이미지 추가하기")
	@RequestMapping(value="image", method=RequestMethod.POST)
	public JSONResult addImage(@RequestBody ProductImage productImage) {
		boolean addResult = productService.addImage(productImage);
		return JSONResult.success(addResult);
	}
	
	@ApiOperation(value = "상품이미지 삭제하기")
	@RequestMapping(value="image/{imageNo}", method=RequestMethod.DELETE)
	public JSONResult removeImage(@PathVariable Long imageNo) {
		boolean removeResult = productService.removeImage(imageNo);
		return JSONResult.success(removeResult);
	}
	
	@ApiOperation(value = "상품옵션 추가하기")
	@RequestMapping(value="option", method=RequestMethod.POST)
	public JSONResult addOption(@RequestBody OptionVo optionVo) {
		boolean addResult = productService.addOption(optionVo);
		return JSONResult.success(addResult);
	}
	
	@ApiOperation(value = "상품옵션 삭제하기")
	@RequestMapping(value="option/{productNo}/{optionNo}/{optionValue}", method=RequestMethod.DELETE)
	public JSONResult removeOption( @PathVariable Long productNo , @PathVariable Long optionNo, @PathVariable String optionValue) {
		boolean removeResult = productService.removeOption(productNo, optionNo, optionValue);
		return JSONResult.success(removeResult);
	}

}
