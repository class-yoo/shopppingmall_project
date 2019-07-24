package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.vo.DisplayedProductVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductImage;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public boolean add(ProductVo productVo) {
		
		Long recentlyProductNo = productDao.insertProduct(productVo);
		
		for (DisplayedProductVo displayedProductVo : productVo.getDisplayedProducts()) {
			displayedProductVo.setProductNo(recentlyProductNo);
			int insertResult = productDao.insertDisplayedProduct(displayedProductVo);
			
			if(1!=insertResult) return false;
		}
		
		for (OptionVo optionVo : productVo.getOptions()) {
			optionVo.setProductNo(recentlyProductNo);
			int insertResult = productDao.insertOption(optionVo);
			
			if(1!=insertResult) return false;
		}
		
		for (ProductImage image : productVo.getProductImages()) {
			image.setProductNo(recentlyProductNo);
			int insertResult = productDao.insertImage(image);
			
			if(1!=insertResult) return false;
		}
		
		return true;
	}
	
 	
	public ProductVo getProductByProductNo(Long productNo) {

		return productDao.selectProductByProductNo(productNo);
	}

	public boolean modify(ProductVo productVo) {

		return 1 == productDao.updateProduct(productVo);
	}

	public boolean remove(Long productNo) {

		return 1 == productDao.deleteProduct(productNo);
	}

	public Long getProductCount(String keyword, String category) {
		return productDao.selectProductCount(keyword, category);
	}

	public List<ProductVo> getSearchProductList(String keyword, String category, int startPageNum, int showBoardNum) {
		
		return productDao.selectSearchProductList(keyword,category,startPageNum, showBoardNum);
	}
	
	

}
