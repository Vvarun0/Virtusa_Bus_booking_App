package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.City;
import com.virtusa.travelline.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> getAllCity() {
		return cityRepository.findAll();
	}

	public City getCityById(int cityId) {
		return cityRepository.findById(cityId).orElse(null);
	}

	public City addCity(City city) {
		return cityRepository.save(city);
	}
	

    public String getCity(City cityId){
		return cityRepository.getSource(cityId.getCityId());
	}

	public boolean deleteCity(int cityId) {
		boolean status = false;
		cityRepository.deleteById(cityId);
		status = true;
		return status;
	}

	public City updateCity(City city) {
		return cityRepository.save(city);
	}

}
