package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.vo.OrderVo;

import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("/order")
public class OrderAPIController {
	
	@Autowired
	private OrderService OrderService;
	
	@ApiOperation(value = "주문하기")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSONResult add(@RequestBody OrderVo orderVo) {
		
		System.out.println(orderVo);
		boolean orderAddResult = OrderService.add(orderVo);
		
		return JSONResult.success(orderAddResult);
	}
	
	@ApiOperation(value = "주문목록보기")
	@RequestMapping(value="/list/{userId}", method=RequestMethod.GET)
	public JSONResult list(@PathVariable String userId) {
		
		List<OrderVo> orderAddResult = OrderService.getOrderListByUserId(userId);
		
		return JSONResult.success(orderAddResult);
	}
	
	
	@ApiOperation(value = "주문상세보기")
	@RequestMapping(value="/{orderNo}", method=RequestMethod.GET)
	public JSONResult detail(@PathVariable Long orderNo) {
		
		OrderVo orderVo = OrderService.getOrderByOrderNo(orderNo);
		
		return JSONResult.success(orderVo);
	}
	
}