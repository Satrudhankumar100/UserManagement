package com.user.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.CityDTO;
import com.user.dto.StateDTO;
import com.user.entity.CityEntity;
import com.user.entity.CountryEntity;
import com.user.entity.StateEntity;
import com.user.repo.CityRepository;
import com.user.repo.CountryRepository;
import com.user.repo.StateRepository;
import com.user.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	CountryRepository countryRepo;

	@Autowired
	StateRepository stateRepo;

	@Autowired
	CityRepository cityRepo;

	@Override
	public List<CountryEntity> getAllCountries() {
		return countryRepo.findAll();
	}

	@Override
	public List<StateDTO> getAllStates(Integer countryId) {

		List<StateEntity> states = stateRepo.findByCountryCountryId(countryId);

		List<StateDTO> stateDTO = states.stream().map(state -> {
			StateDTO dto = new StateDTO();
			BeanUtils.copyProperties(state, dto);
			return dto;
		}).collect(Collectors.toList());

		return stateDTO;

	}

	@Override
	public List<CityDTO> getAllCities(Integer countryId,Integer stateId) {
		 List<CityEntity> cities = cityRepo.findByCountryCountryIdAndStateStateId(countryId, stateId);
		List<CityDTO> cityDTO= cities.stream().map(city->
		 {
			CityDTO dto = new CityDTO(); 
			BeanUtils.copyProperties(city, dto);
			return dto;
		 }).collect(Collectors.toList());
		 return cityDTO;
	}
	
	
	@Override
	public CityEntity getLocation(Integer cityId) {
		Optional<CityEntity> byId = cityRepo.findById(cityId);
		if(byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

}
