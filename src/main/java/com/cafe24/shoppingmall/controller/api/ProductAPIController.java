package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@ApiOperation(value = "상품추가하기")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSONResult add(@RequestBody ProductVo productVo) {
		boolean addResult = productService.add(productVo);
		
		return JSONResult.success(addResult);
	}
	
	@ApiOperation(value = "상품정보보기")
	@RequestMapping(value="/{productNo}", method=RequestMethod.GET)
	public JSONResult get(@PathVariable Long productNo) {
		
		ProductVo productVo = productService.getProductByProductNo(productNo);
		
		return JSONResult.success(productVo);
	}
	
	@ApiOperation(value = "상품수정하기")
	@RequestMapping(value="/modify", method=RequestMethod.PUT)
	public JSONResult modify(@RequestBody ProductVo productVo) {
		boolean modifyResult = productService.modify(productVo);
		return JSONResult.success(modifyResult);
	}
	
	@ApiOperation(value = "상품삭제하기")
	@RequestMapping(value="/remove/{productNo}", method=RequestMethod.DELETE)
	public JSONResult remove(@PathVariable Long productNo) {
		boolean removeResult = productService.remove(productNo);
		return JSONResult.success(removeResult);
	}
	
	@ApiOperation(value = "상품목록보기")
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public JSONResult list(@RequestParam (value="keyword" , required= true, defaultValue="")String keyword,
			@RequestParam(value="categoryNo" , required= true, defaultValue="0") Long categoryNo,
			@RequestParam(value="curPageNum" , required= true, defaultValue="1") int curPageNum,
			@RequestParam(value="showProductNum" , required= true, defaultValue="5") int showProductNum) {
		
		Long productCount = productService.getProductCount(keyword, categoryNo);
		Paging paging = new Paging();
		paging.pagingSetting(productCount, showProductNum , curPageNum);
		
		List<ProductVo> list = productService.getSearchProductList(keyword, categoryNo, paging.getStartPageNum(), showProductNum);
		
		return JSONResult.success(list);
	}
	
	@ApiOperation(value = "상품이미지 추가하기")
	@RequestMapping(value="image/add", method=RequestMethod.POST)
	public JSONResult addImage(@RequestBody ProductImage productImage) {
		boolean addResult = productService.addImage(productImage);
		return JSONResult.success(addResult);
	}
	
	@ApiOperation(value = "상품이미지 삭제하기")
	@RequestMapping(value="image/remove/{imageNo}", method=RequestMethod.DELETE)
	public JSONResult removeImage(@PathVariable Long imageNo) {
		boolean removeResult = productService.removeImage(imageNo);
		return JSONResult.success(removeResult);
	}
	
	@ApiOperation(value = "상품옵션 추가하기")
	@RequestMapping(value="option/add", method=RequestMethod.POST)
	public JSONResult addOption(@RequestBody OptionVo optionVo) {
		boolean addResult = productService.addOption(optionVo);
		return JSONResult.success(addResult);
	}
	
	@ApiOperation(value = "상품옵션 삭제하기")
	@RequestMapping(value="option/remove/{productNo}/{optionNo}/{optionValue}", method=RequestMethod.DELETE)
	public JSONResult removeOption( @PathVariable Long productNo , @PathVariable Long optionNo, @PathVariable String optionValue) {
		boolean removeResult = productService.removeOption(productNo, optionNo, optionValue);
		return JSONResult.success(removeResult);
	}
	
}
