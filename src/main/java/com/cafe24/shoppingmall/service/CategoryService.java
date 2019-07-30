package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.repository.CategoryDao;
import com.cafe24.shoppingmall.vo.CategoryVo;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	public boolean add(CategoryVo categoryVo) {
		
		return 1 == categoryDao.insertCategory(categoryVo);
	}

	public List<CategoryVo> getCategoryList() {
		return categoryDao.selectCategoryList();
	}

	public boolean remove(Long categoryNo) {
		return 1 == categoryDao.deleteCategory(categoryNo);
	}
}
