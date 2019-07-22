package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OrderProductVo;
import com.cafe24.shoppingmall.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public boolean add(OrderVo orderVo) {

		System.out.println(orderVo);
		if (1 == orderDao.insertOrder(orderVo)) {
			for (OrderProductVo orderProductVo : orderVo.getOrderProductVos()) {
				System.out.println(orderProductVo);
				if (orderDao.insertOrderProduct(orderProductVo) != 1)
					return false;
			}
		}else {
			return false;
		}
		return true;
	}

	
	
	public List<OrderVo> getOrderListByUserId(String userId) {
		
		List<OrderVo> orderList = orderDao.selectOrderListByUserId(userId);
			
		return orderList;
	}

}
