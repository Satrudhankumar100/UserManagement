package com.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

	
	/**
	 *  This query is used fetch All cities belonging  country and state
	 * @param countryId
	 * @param stateId
	 * @return List<CityEntity>
	 */
	
	List<CityEntity> findByCountryCountryIdAndStateStateId(Integer countryId,Integer stateId );
}
