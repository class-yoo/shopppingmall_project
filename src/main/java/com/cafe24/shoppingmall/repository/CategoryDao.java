package com.cafe24.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;

	public int insertCategory(CategoryVo categoryVo) {
		return sqlSession.insert("category.insertCategory", categoryVo);
	}

	public List<CategoryVo> selectCategoryList() {
		return sqlSession.selectList("category.selectCategoryList");
	}

	public int deleteCategory(Long categoryNo) {
		return sqlSession.delete("category.deleteCategory");
	}

}
