package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "User_tab")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPwd;
    private String userPhno;

    @ManyToOne
    @JoinColumn(name = "country_id") // Foreign key column
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "state_id") // Foreign key column
    private StateEntity state;

    @ManyToOne
    @JoinColumn(name = "city_id") // Foreign key column
    private CityEntity city;

    private boolean isReset;
}
