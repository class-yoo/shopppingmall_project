package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.repository.AdminDao;
import com.cafe24.shoppingmall.vo.UserVo;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public boolean checkOverapId(String id) {

		String userId = adminDao.selectAdminByAdminId(id);
		
		return null != userId;
	}

	public boolean join(UserVo userVo) {
		
		return 1 == adminDao.insertAdmin(userVo);
	}

	public UserVo login(UserVo userVo) {
		
		return adminDao.selectAdminByAdminIdAndPassword(userVo);
	}

}
