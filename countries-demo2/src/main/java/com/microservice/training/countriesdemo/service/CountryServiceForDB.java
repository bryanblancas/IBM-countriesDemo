package com.microservice.training.countriesdemo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.training.countriesdemo.model.Continent;
import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.CountryRequestModel;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.repository.api.CountryJpaRepository;


@Service
public class CountryServiceForDB {

	@Autowired
	CountryJpaRepository countriesRepository;
	
	public ArrayList<CountryEntity> findByContinent(String continent) {
		
		Iterable<CountryEntity> countries = countriesRepository.findAll();
		
		ArrayList<CountryEntity> countriesFromContinent = new ArrayList();
		for(CountryEntity ce : countries) {
			if(ce.getContinent().equalsIgnoreCase(continent))
				countriesFromContinent.add(ce);
		}
		
		return countriesFromContinent;
	}
	
	
	public Optional<CountryEntity> findById(int id) {
		Optional<CountryEntity> country = countriesRepository.findById(id);
		return country;
	}
	
	
	public CountryEntity saveCountry(CountryRequestModel countryToSave) {
		
		/*CountryEntity required by save()*/
		CountryEntity country = new CountryEntity();
		country.setContinent(countryToSave.getContinentName());
		country.setCapital(countryToSave.getCapitalName());
		country.setName(countryToSave.getCountryName());
		//country.setCountryId(183);
		
		country = countriesRepository.save(country);
		return country;
	}
	
}
