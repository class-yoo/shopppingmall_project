package com.cafe24.shoppingmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.ProductVo;

@Repository
public class ProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertProduct(ProductVo productVo) {
		
		return sqlSession.insert("product.insertProduct", productVo);
	}

	public ProductVo selectProductByProductNo(Long productNo) {
		
		return sqlSession.selectOne("product.selectProductByProductNo", productNo);
	}

	public int updateProduct(ProductVo productVo) {
		
		return sqlSession.update("product.updateProduct", productVo);
	}

	public int deleteProduct(Long productNo) {
		return 0;
	}

	
	
}
