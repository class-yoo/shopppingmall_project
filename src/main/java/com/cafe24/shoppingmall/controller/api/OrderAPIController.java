package com.cafe24.shoppingmall.controller.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.vo.OrderVo;

import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("api/order")
public class OrderAPIController {

	@ApiOperation(value = "주문하기")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSONResult add(@RequestBody OrderVo orderVo) {
		
		return JSONResult.success(null);
	}
	
}
