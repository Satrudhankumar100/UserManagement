package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

}
