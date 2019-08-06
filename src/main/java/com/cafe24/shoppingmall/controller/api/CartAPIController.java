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
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.vo.CartVo;

import io.swagger.annotations.ApiOperation;

@RestController("cartAPIController")
@RequestMapping("/cart")
public class CartAPIController {
	
	@Autowired
	private CartService cartService;

	@ApiOperation(value = "장바구니담기")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> add(@RequestBody CartVo cartVo) {
		
		HttpStatus status = HttpStatus.OK;
		String message = null;
		JSONResult jsonResult = JSONResult.success(true);
		
		boolean putResult = cartService.put(cartVo);
		
		if(!putResult) {
			status = HttpStatus.BAD_REQUEST;
			message = "장바구니담기가 실패했습니다.";
			jsonResult = JSONResult.fail(message);
		}
		
		return makeResponseEntity(status, jsonResult);
	}

	@ApiOperation(value = "장바구니목록보기")
	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	public JSONResult list(@PathVariable(value="userId") String userId) {
		
		List<CartVo> list = cartService.getCartListByUserId(userId);
		
		return JSONResult.success(list);
	}
	
	
	public ResponseEntity<JSONResult> makeResponseEntity(HttpStatus status, JSONResult jsonResult){
		return ResponseEntity.status(status).body(jsonResult);
	}
}
