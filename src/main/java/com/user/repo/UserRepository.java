package com.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
		Optional<UserEntity> findByUserEmail(String userEmail);

}
