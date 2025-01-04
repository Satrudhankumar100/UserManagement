package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDTO;
import com.user.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/show")
	public ResponseEntity<String> showUserForm(@RequestBody UserDTO user) {
		boolean status = userService.saveUser(user);
		return ResponseEntity.ok("Success....");
	}

}
