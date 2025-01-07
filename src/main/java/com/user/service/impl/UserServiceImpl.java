package com.user.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.LoginDTO;
import com.user.dto.ResetDTO;
import com.user.dto.UserDTO;
import com.user.entity.CityEntity;
import com.user.entity.UserEntity;
import com.user.repo.UserRepository;
import com.user.service.IAddressService;
import com.user.service.IUserService;
import com.user.utility.CustomMsg;
import com.user.utility.service.IEmailService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	IEmailService emailService;
	
	@Autowired
	IAddressService addressService;

	@Override
	public boolean saveUser(UserDTO user) {

		// finding unique email or not into user_entity
		if (isExisted(user.getUserEmail()))
			return false;
		String randomPwd = generateRandomPwd();
		String subject = CustomMsg.subject;
		String emailBody = CustomMsg.emailBody(randomPwd);
		// retreive email from user
		String email = user.getUserEmail();
		// sending email for password
		boolean emailSend = emailService.emailSend(email, subject, emailBody);
		// creating UserEntity object
		UserEntity entity = new UserEntity();
		// copy user data into entity table
		BeanUtils.copyProperties(user, entity);
		CityEntity location = addressService.getLocation(user.getCity());
		entity.setCountry(location.getCountry());
		entity.setState(location.getState());
		entity.setCity(location);
		entity.setUserPwd(randomPwd);
		UserEntity saved = userRepo.save(entity);

		return true;
	}

	@Override
	public Integer verifyUser(LoginDTO login) {
		//finding user exists or not using email id
		Optional<UserEntity> entity = userRepo.findByUserEmail(login.getUserEmail());
		if (entity.isPresent()) {
			UserEntity loginEntity = entity.get();
			if (loginEntity.getUserPwd().equals(login.getUserPwd()))
				return loginEntity.getUserId();
		}

		return -1;
	}

	@Override
	public boolean resetPwd(Integer userId, ResetDTO resetDTO) {
		Optional<UserEntity> byId = userRepo.findById(userId);
		UserEntity entity = byId.get();
		String userPwd = entity.getUserPwd();
		if (resetDTO.getUserNewPwd().equals(resetDTO.getUserConfPwd()) && userPwd.equals(resetDTO.getUserOldPwd())) {
			entity.setUserPwd(resetDTO.getUserNewPwd());
			entity.setReset(true);
			userRepo.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean isPwdActive(Integer userId) {
		Optional<UserEntity> byId = userRepo.findById(userId);
		UserEntity entity = byId.get();
		if (entity.isReset())
			return true;
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

	/**
	 * 2. This method is used generate Random Password
	 * 
	 * @param size
	 * @return
	 */
	private String generateRandomPwd() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();

		StringBuilder pwd = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			int index = random.nextInt(characters.length());
			pwd.append(characters.charAt(index));
		}

		return pwd.toString();

	}

}
