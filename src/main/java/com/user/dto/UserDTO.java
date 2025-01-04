package com.user.dto;

import lombok.Data;

@Data
public class UserDTO {

	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPhno;
	
	private Integer country;
	private Integer state;
	private Integer city;

}
