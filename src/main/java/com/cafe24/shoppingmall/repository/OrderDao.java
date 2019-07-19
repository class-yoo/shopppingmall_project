package com.cafe24.shoppingmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.OrderProductVo;
import com.cafe24.shoppingmall.vo.OrderVo;

@Repository
public class OrderDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertOrder(OrderVo orderVo) {
		
		return sqlSession.insert("order.insertOrder", orderVo);
	}
	
	
	public int insertOrderProduct(OrderProductVo orderProductVo) {
		
		return sqlSession.insert("order.insertOrderProduct", orderProductVo); 
		
	}

}
