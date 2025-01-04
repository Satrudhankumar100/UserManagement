package com.user.service;

import com.user.entity.UserEntity;

public interface IUserService {

	/**
	 * 1. THIS IS METHOD IS USED TO SAVE USER INTO DATABASE
	 * 
	 * @param UserEntity
	 * @return String
	 */
		
		String saveUser(UserEntity user);
	
		
		
	/**
	 * 2. THIS IS METHOD IS USED TO VERIFY EMAIL
	 * @param email
	 * @param pwd
	 * @return boolean
	 */
		
		boolean emailCheck(String email,String pwd);
		
		
	/**
	 *  3. THIS METHOD IS USED TO 	
	 */

}
