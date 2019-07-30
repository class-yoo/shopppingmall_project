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

	public Long selectProductCount(String keyword, Long categoryNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("categoryNo", categoryNo);

		return sqlSession.selectOne("product.selectProductCount", map);
	}

	public List<ProductVo> selectSearchProductList(String keyword, Long categoryNo, int startPageNum,
			int showProductNum) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("categoryNo", categoryNo);
		map.put("startPageNum", startPageNum);
		map.put("showProductNum", showProductNum);
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

	public int deleteProduct(Long productNo) {
		return sqlSession.delete("product.deleteProduct", productNo);
	}

	public int deleteOptionByProductNo(Long productNo) {
		return sqlSession.delete("product.deleteOptionByProductNo", productNo);
	}

	public int deleteDisplayedProductByProductNo(Long productNo) {
		return sqlSession.delete("product.deleteDisplayedProductByProductNo", productNo);

	}

	public int deleteImageByProductNo(Long productNo) {
		return sqlSession.delete("product.deleteImageByProductNo", productNo);

	}

	public int deleteImageByImageNo(Long imageNo) {
		return sqlSession.delete("product.deleteImageByImageNo", imageNo);
	}

	public int deleteOptionByOptionNo(Long optionNo) {
		return sqlSession.delete("product.deleteOptionByOptionNo", optionNo);
	}

	public int deleteDisplayedProductByOption(Long productNo, String optionValue) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productNo", productNo);
		map.put("optionValue", optionValue);
		return sqlSession.delete("product.deleteDisplayedProductByOption", map);
	}

}
