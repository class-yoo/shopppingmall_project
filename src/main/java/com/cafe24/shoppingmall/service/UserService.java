package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.UserDao;
import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	public boolean checkOverapId(String id) {
		
		boolean checkOverapResult = true;
		
		return checkOverapResult;
	}

	public boolean join(UserVo userVo) {
		
		boolean joinResult = true;
		
		return joinResult;
	}
	
	public UserVo getUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserVo login(UserVo userVo) {
		
		UserVo loginUserVo = new UserVo();
		loginUserVo.setId("hgd888");
		loginUserVo.setName("홍길동");
		
		return loginUserVo;
	}
	
	
}
