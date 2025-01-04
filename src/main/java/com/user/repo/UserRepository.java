package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
