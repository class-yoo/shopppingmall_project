package com.cafe24.shoppingmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
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
	@RequestMapping(value="/add/{productNo}", method=RequestMethod.GET)
	public JSONResult get(@PathVariable Long productNo) {
		
		ProductVo productVo = productService.getProductByProductNo(productNo);
		
		return JSONResult.success(productVo);
	}
	
	@ApiOperation(value = "상품수정하기")
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public JSONResult modify(@RequestBody ProductVo productVo) {
		boolean modifyResult = productService.modify(productVo);
		return JSONResult.success(modifyResult);
	}
	
	@ApiOperation(value = "상품삭제하기")
	@RequestMapping(value="/remove/{productNo}", method=RequestMethod.GET)
	public JSONResult remove(@PathVariable Long productNo) {
		
		boolean removeResult = productService.remove(productNo);
		return JSONResult.success(removeResult);
	}
}
