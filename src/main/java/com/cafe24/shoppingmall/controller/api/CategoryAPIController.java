package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CategoryService;
import com.cafe24.shoppingmall.vo.CategoryVo;

import io.swagger.annotations.ApiOperation;

@RestController("categoryAPIController")
@RequestMapping("/category")
public class CategoryAPIController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation(value = "카테고리추가하기")
	@RequestMapping(value="", method=RequestMethod.POST)
	public JSONResult add(@RequestBody CategoryVo categoryVo) {
		boolean addResult = categoryService.add(categoryVo);
		
		return JSONResult.success(addResult);
	}
	
	@ApiOperation(value = "카테고리목록보기")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public JSONResult get() {
		
		List<CategoryVo> categoryList = categoryService.getCategoryList();
		
		return JSONResult.success(categoryList);
	}
	
	@ApiOperation(value = "카테고리삭제하기")
	@RequestMapping(value="/{categoryNo}", method=RequestMethod.DELETE)
	public JSONResult remove(@PathVariable Long categoryNo) {
		
		boolean removeResult = categoryService.remove(categoryNo);
		return JSONResult.success(removeResult);
	}
	
}
