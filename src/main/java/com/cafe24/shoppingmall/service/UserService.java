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

		String userId = userDao.selectUserByUserId(id);
		return userId == null ? false : true;
	}

	public boolean join(UserVo userVo) {

		int joinResult = userDao.insertUser(userVo);
		

		return joinResult == 1 ? true : false;
	}

	public UserVo login(UserVo userVo) {
		
		UserVo loginUserVo = userDao.selectUserByUserIdAndPassword(userVo);
		
		return loginUserVo;
	}

}
