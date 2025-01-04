package com.user.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class CountryEntity {

	@Id
	private Integer countryId;
	private String countryName;

	@OneToMany(mappedBy = "country") // Maps to the `country` field in StateEntity
	private List<StateEntity> states;
	
	@OneToMany(mappedBy = "country") // Maps to the `country` field in CityEntity
	private List<CityEntity> city;
}
