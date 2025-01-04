package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.TestEntity;

public interface TestRepository  extends JpaRepository<TestEntity, Integer>{

}
