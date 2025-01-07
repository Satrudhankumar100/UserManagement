package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.CityDTO;
import com.user.dto.StateDTO;
import com.user.entity.CountryEntity;
import com.user.service.IAddressService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AddressController {

	@Autowired
	IAddressService addressService;

	@GetMapping("/countries")
	public ResponseEntity<List<CountryEntity>> getAllCountries() {
		List<CountryEntity> countries = addressService.getAllCountries();
		return ResponseEntity.ok(countries);
	}

	@GetMapping("/states")
	public ResponseEntity<List<StateDTO>> getStatesByCountry(@RequestParam Integer countryId) {
		
		List<StateDTO> states = addressService.getAllStates(countryId);
		for(StateDTO st:states) {
			System.out.print(st.getStateName()+"\t");
		}
		System.out.println();
		return ResponseEntity.ok(states);
	}

	
	@GetMapping("/cities")
	public ResponseEntity<List<CityDTO>> getCitiesByState(@RequestParam Integer countryId,
			@RequestParam Integer stateId) {
		List<CityDTO> cities = addressService.getAllCities(countryId, stateId);
		return ResponseEntity.ok(cities);
	}

//	@PostMapping("/test")
//	public ResponseEntity<String> showUserForm() {
//		List<CountryEntity> list = addressService.getAllCountries();
//		CountryEntity country = list.get(0);
//
//		List<StateEntity> allStates = addressService.getAllStates(country.getCountryId());
//		List<CityEntity> allCities = addressService.getAllCities(country.getCountryId(), allStates.get(0).getStateId());
//		log.info(allCities.get(0).getCityName());
//		log.info(allStates.get(0).getStateName());
//		log.info(country.getCountryName());
//		return ResponseEntity.ok("Success....");
//	}

}
