package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.travelline.models.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{

	@Query("SELECT  b.capacity FROM Bus b WHERE b.service.serviceId = :serviceid")
	public int getBusCapacity(@Param("serviceid") String serviceId);
}
