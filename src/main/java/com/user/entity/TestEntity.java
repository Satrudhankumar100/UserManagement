package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestEntity {
	@Id
	private Integer id;
	private String name;

}
