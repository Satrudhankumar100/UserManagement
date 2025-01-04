package com.user.service;

import com.user.dto.LoginDTO;
import com.user.dto.UserDTO;

public interface IUserService {

	/**
	 * 1. THIS IS METHOD IS USED TO SAVE USER INTO DATABASE
	 * 
	 * @param UserDTO
	 * @return String
	 */
		boolean saveUser(UserDTO user);
	
		
	/**
	 * 2. THIS IS METHOD IS USED verify credential 
	 * @param email
	 * @param pwd
	 * @return boolean
	 */
		
		boolean verfyUser(LoginDTO login);
		
		
	/**
	 *  3. THIS METHOD IS USED TO RESET PASSWORD
	 *  @param userId
	 *  @param oldPwd
	 *  @param newPwd
	 *  @return boolean
	 */
		boolean resetPwd(Integer userId,String oldPwd,String newPwd);
		
		
		/**
		 *  4. THIS METHOD IS USED TO <br><b>CHECK USER ACTIVE OR NOT</b>
		 * @param userId
		 * @return boolean
		 */
		boolean isPwdActive(Integer userId);
		

}
