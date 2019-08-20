package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.CartVo;

@Repository
public class CartDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertCart(CartVo cartVo) {
		
		return sqlSession.insert("cart.insertCart", cartVo);
	}

	public List<CartVo> selectCartListByUserId(String userId) {
		
		return sqlSession.selectList("cart.selectCartListByUserId", userId);
	}

	public CartVo selectCartByCartNo(Long cartNo) {
		return sqlSession.selectOne("cart.selectCartByCartNo", cartNo);
	}
	
}
