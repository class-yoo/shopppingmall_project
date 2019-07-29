package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.vo.DisplayedProductVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductImage;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public boolean add(ProductVo productVo) {
		
		int productInsertResult = productDao.insertProduct(productVo);
		
		if(productInsertResult != 1) return false;
		
		for (DisplayedProductVo displayedProductVo : productVo.getDisplayedProducts()) {
			displayedProductVo.setProductNo(productVo.getNo());
			int insertResult = productDao.insertDisplayedProduct(displayedProductVo);
			
			if(1!=insertResult) return false;
		}
		
		for (OptionVo optionVo : productVo.getOptions()) {
			optionVo.setProductNo(productVo.getNo());
			int insertResult = productDao.insertOption(optionVo);
			
			if(1!=insertResult) return false;
		}
		
		for (ProductImage image : productVo.getProductImages()) {
			image.setProductNo(productVo.getNo());
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
		return 1==productDao.deleteOptionByProductNo(productNo) && 1 == productDao.deleteDisplayedProductByProductNo(productNo)
				&& 1 == productDao.deleteImageByProductNo(productNo) && 1 == productDao.deleteProduct(productNo);
	}

	public Long getProductCount(String keyword, Long categoryNo) {
		return productDao.selectProductCount(keyword, categoryNo);
	}

	public List<ProductVo> getSearchProductList(String keyword, Long categoryNo, int startPageNum, int showProductNum) {
		return productDao.selectSearchProductList(keyword,categoryNo,startPageNum, showProductNum);
	}

	public boolean addImage(ProductImage productImage) {
		return 1==productDao.insertImage(productImage);
	}
	
	public boolean removeImage(Long imageNo) {
		return 1==productDao.deleteImageByImageNo(imageNo);
	}

	public boolean addOption(OptionVo optionVo) {
		return 1==productDao.insertOption(optionVo);
	}

	public boolean removeOption(Long productNo, Long optionNo, String optionValue) {
		return 1==productDao.deleteOptionByOptionNo(optionNo) && 
				1==productDao.deleteDisplayedProductByOption(productNo, optionValue);
	}

}
