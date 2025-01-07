package com.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {

	/**
	 * This query is used fetch All states belonging to the country
	 * 
	 * @param countryId
	 * @return List<StateEntity>
	 */

	List<StateEntity> findByCountryCountryId(Integer countryId);

}
