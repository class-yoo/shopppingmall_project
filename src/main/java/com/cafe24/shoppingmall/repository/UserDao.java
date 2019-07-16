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

	public String selectUserByUserId(String id) {
		String userId = sqlSession.selectOne("user.selectUserByUserId", id);
		return userId;
	}

	public int insertUser(UserVo userVo) {
		int insertUserResult = sqlSession.insert("user.insertUser", userVo);
		return insertUserResult;
	}

	public UserVo selectUserByUserIdAndPassword(UserVo userVo) {
		UserVo loginUser = sqlSession.selectOne("user.selectUserByUserIdAndPassword", userVo);
		return loginUser;
	}
}
