package com.cafe24.shoppingmall.dto;

import java.util.List;

import com.cafe24.shoppingmall.vo.CartVo;

public class CartDTO {
	
	private String userId;
	private List<CartVo> cartList;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<CartVo> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartVo> cartList) {
		this.cartList = cartList;
	}
	
}
