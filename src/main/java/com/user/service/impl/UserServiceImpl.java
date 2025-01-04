package com.user.service.impl;

import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;
import com.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public boolean emailCheck(String email, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
