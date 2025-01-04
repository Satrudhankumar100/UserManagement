package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CityEntity {

	@Id
	private Integer cityId;
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "state_id") // Foreign key column
	private StateEntity state;
	
	@ManyToOne
	@JoinColumn(name="country_id")	// Foreign key column
	private CountryEntity country;

}
