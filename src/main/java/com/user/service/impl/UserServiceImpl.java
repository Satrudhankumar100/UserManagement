package com.user.service.impl;

import java.beans.Beans;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.LoginDTO;
import com.user.dto.UserDTO;
import com.user.entity.UserEntity;
import com.user.repo.UserRepository;
import com.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public boolean saveUser(UserDTO user) {

		// finding unique email or not into user_entity
		if (isExisted(user.getUserEmail()))
			return false;

		// creating UserEntity object
		UserEntity entity = new UserEntity();
		// copy user data into entity table
		BeanUtils.copyProperties(user, entity);

		UserEntity saved = userRepo.save(entity);

		return true;
	}

	@Override
	public boolean verfyUser(LoginDTO login) {
			
		
		
		return false;
	}

	@Override
	public boolean resetPwd(Integer userId, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPwdActive(Integer userId) {
		return false;
	}

	/**
	 * 1. This method is used to check email exists or not into user_entity
	 * 
	 * @param email
	 * @return
	 */
	private boolean isExisted(String email) {
		return userRepo.findByUserEmail(email).isPresent();
	}

}
