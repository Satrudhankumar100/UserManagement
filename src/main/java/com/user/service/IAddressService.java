package com.user.service;

import java.util.List;

import com.user.dto.CityDTO;
import com.user.dto.StateDTO;
import com.user.entity.CityEntity;
import com.user.entity.CountryEntity;

public interface IAddressService {

	/**
	 * 1. This method is used find all countries
	 * 
	 * @return List<CountryEntity>
	 */

	List<CountryEntity> getAllCountries();

	/**
	 * 2. This method is used find all states
	 * 
	 * @param countryId
	 * @return
	 */
	List<StateDTO> getAllStates(Integer countryId);

	/**
	 * 3. This method is used find all cities
	 * 
	 * @param stateId
	 * @param countryId
	 * @return
	 */
	List<CityDTO> getAllCities(Integer countryId, Integer stateId);
	
	
	
	/**
	 *  4. 
	 * @return
	 */
	CityEntity getLocation(Integer cityId);
	
	
	
	
	
	
	

}
