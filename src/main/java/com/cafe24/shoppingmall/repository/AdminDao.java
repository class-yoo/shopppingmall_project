package com.cafe24.shoppingmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.UserVo;

@Repository
public class AdminDao {

	@Autowired
	private SqlSession sqlSession;

	public String selectAdminByAdminId(String id) {
		String adminId = sqlSession.selectOne("admin.selectAdminByAdminId", id);
		return adminId;
	}

	public int insertAdmin(UserVo userVo) {
		int insertAdminResult = sqlSession.insert("admin.insertAdmin", userVo);
		return insertAdminResult;
	}
	
	public UserVo selectAdminByAdminIdAndPassword(UserVo userVo) {
		UserVo loginAdmin = sqlSession.selectOne("admin.selectAdminByAdminIdAndPassword", userVo);
		return loginAdmin;
	}

	public UserVo get(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
