package com.user.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class StateEntity {

	@Id
	private Integer stateId;
	private String stateName;

	@ManyToOne
	@JoinColumn(name = "country_id") // Foreign key column
	private CountryEntity country;

	@OneToMany(mappedBy = "state") // Maps to the `state` field in CityEntity
	private List<CityEntity> cities;

}
