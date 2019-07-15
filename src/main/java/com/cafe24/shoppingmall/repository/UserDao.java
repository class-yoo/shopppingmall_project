package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.UserVo;


@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo get(String id) {
		UserVo userVo = sqlSession.selectOne("user.getById", id);
		return userVo;
	}
	
	
	
	public UserVo get(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		UserVo userVo = sqlSession.selectOne("user.getByEmailAndPassword", map);
		
		return userVo;
	}
	
	
}
