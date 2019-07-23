package com.cafe24.shoppingmall.repository;

import java.util.List;

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


	public List<OrderVo> selectOrderListByUserId(String userId) {
		return sqlSession.selectList("order.selectOrderListByUserId", userId);
	}


	public OrderVo selectOrderByOrderNo(Long orderNo) {
		return sqlSession.selectOne("order.selectOrderByOrderNo", orderNo);
	}

}
