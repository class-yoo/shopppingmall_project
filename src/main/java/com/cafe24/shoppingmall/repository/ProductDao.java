package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.DisplayedProductVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductImage;
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
		return sqlSession.update("product.deleteProduct", productNo);
	}

	public Long selectProductCount(String keyword, String category) {
		Map<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("category", category);

		return sqlSession.selectOne("product.selectProductCount", map);
	}

	public List<ProductVo> selectSearchProductList(String keyword, String category, int startPageNum, int showBoardNum) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("category", category);
		map.put("startPageNum", startPageNum);
		map.put("showBoardNum", showBoardNum);
		return sqlSession.selectList("product.selectSearchProductList", map);
	}

	public int insertDisplayedProduct(DisplayedProductVo displayedProductVo) {
		return sqlSession.insert("product.insertDisplayedProduct", displayedProductVo);
	}

	public int insertOption(OptionVo optionVo) {
		return sqlSession.insert("product.insertOption", optionVo);
	}

	public int insertImage(ProductImage image) {
		return sqlSession.insert("product.insertImage", image);
	}

}
