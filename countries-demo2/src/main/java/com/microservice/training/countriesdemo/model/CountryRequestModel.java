package com.microservice.training.countriesdemo.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountryRequestModel {
	private String countryName;
	private String capitalName;
	private String continentName;
}
