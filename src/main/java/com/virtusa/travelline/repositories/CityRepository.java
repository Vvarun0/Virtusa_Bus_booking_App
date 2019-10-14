package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.travelline.models.City;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Integer>{

	@Query("SELECT distinct p.cityName FROM City p WHERE p.cityId = :source")
	public String getSource(@Param("source") int city);
	
	
}
