package com.cafe24.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	public boolean put(CartVo cartVo) {
		
		boolean insertCartResult = true;
		
		return insertCartResult;
	}

	public List<ProductVo> getProductListInCartByUserId(String userId) {
		ProductVo productVo1 = new ProductVo();
		ProductVo productVo2 = new ProductVo();
		ProductVo productVo3 = new ProductVo();
		
		List<ProductVo> productVoListInCart = new ArrayList<ProductVo>();
		productVoListInCart.add(productVo1);
		productVoListInCart.add(productVo2);
		productVoListInCart.add(productVo3);
		
		return productVoListInCart;
	}
	
}
