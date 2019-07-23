package com.cafe24.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.DisplayedProductVo;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public boolean put(CartVo cartVo) {

		return 1 == cartDao.insertCart(cartVo);
	}

	
	public List<CartVo> getCartListByUserId(String userId) {

		List<CartVo> cartList = cartDao.selectCartListByUserId(userId);

//		List<CartVo> cartList2 = new ArrayList<CartVo>();
//
//		CartVo cartVo1 = new CartVo();
//		cartVo1.setNo(2L);
//		cartVo1.setAmount(2);
//
//		CartVo cartVo2 = new CartVo();
//		cartVo1.setNo(13L);
//		cartVo1.setAmount(1);
//
//		ProductVo productVo1 = new ProductVo();
//		productVo1.setConsumerPrice(15000);
//		productVo1.setCode("PPP000");
//		DisplayedProductVo dProductVo1 = new DisplayedProductVo();
//		productVo1.setNo(1L);
//		dProductVo1.setCode(productVo1.getCode() + "BKL");
//		dProductVo1.setOption("블랙/L");
//		dProductVo1.setStockCheck("Y");
//		dProductVo1.setAdditionalFee(2000);
//		dProductVo1.setAmount(3);
//		dProductVo1.setProductVo(productVo1);
//
//		cartVo1.setDisplayedProduct(dProductVo1);
//
//		ProductVo productVo2 = new ProductVo();
//		productVo2.setConsumerPrice(21000);
//		productVo2.setCode("PLT032");
//
//		DisplayedProductVo dProductVo2 = new DisplayedProductVo();
//		dProductVo2.setNo(21L);
//		dProductVo2.setCode(productVo1.getCode() + "BEMH");
//		dProductVo2.setOption("블루/M/반팔");
//		dProductVo2.setStockCheck("Y");
//		dProductVo1.setAdditionalFee(0);
//		dProductVo2.setAmount(3);
//		dProductVo2.setProductVo(productVo2);
//
//		cartVo2.setDisplayedProduct(dProductVo2);
//
//		cartList2.add(cartVo1);
//		cartList2.add(cartVo2);

		return cartList;
	}

}
