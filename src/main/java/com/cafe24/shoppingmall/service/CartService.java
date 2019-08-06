package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.CartVo;

@Service
@Transactional
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	public boolean put(CartVo cartVo) {
		return 1 == cartDao.insertCart(cartVo);
	}

	
	public List<CartVo> getCartListByUserId(String userId) {

		List<CartVo> cartList = cartDao.selectCartListByUserId(userId);

		return cartList;
	}

}
