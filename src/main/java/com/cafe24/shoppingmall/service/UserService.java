package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.repository.UserDao;
import com.cafe24.shoppingmall.vo.UserVo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean checkOverapId(String id) {

		String userId = userDao.selectUserByUserId(id);
		
		return null == userId;
	}

	public boolean join(UserVo userVo) {
		
		return 1 == userDao.insertUser(userVo);
	}

	public UserVo login(UserVo userVo) {
		
		return userDao.selectUserByUserIdAndPassword(userVo);
	}

}
