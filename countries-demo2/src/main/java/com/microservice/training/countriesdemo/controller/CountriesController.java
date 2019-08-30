package com.microservice.training.countriesdemo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.training.countriesdemo.model.CountryRequestModel;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.service.CountryServiceForDB;

@RestController
public class CountriesController {

  @Autowired
  CountryServiceForDB searchCountries;
 
  @GetMapping(path = "/api/bryan/fromdb/name/{continentName}")
  public ArrayList<CountryEntity> findCountryByContinent(@PathVariable String continentName) {
	  ArrayList<CountryEntity> lce = searchCountries.findByContinent(continentName);
	  return lce;
  }
  
  @GetMapping(path = "/api/bryan/fromdb/id/{continentId}")
  public Optional<CountryEntity> findCountryById(@PathVariable int continentId) {
	  Optional<CountryEntity> country = searchCountries.findById(continentId);
	  return country;
  }
 
  @RequestMapping(
		  value="/api/bryan/fromdb/save/country",
		  method = RequestMethod.POST,
		  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
		  )
  public String saveCountry(@RequestBody CountryRequestModel requestSaveCountry) {
	  CountryEntity i = searchCountries.saveCountry(requestSaveCountry);
	  return "Se ha guardado: "+i.getName();
  }
}
