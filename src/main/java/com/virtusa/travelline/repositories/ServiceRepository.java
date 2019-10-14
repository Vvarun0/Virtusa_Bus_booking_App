package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.travelline.models.Service;

public interface ServiceRepository extends JpaRepository<Service, String>{

	@Query("SELECT p.serviceId FROM Service p WHERE p.route.routeId = :source")
	public String getServiceIdForBooking(@Param("source") int routeId);
	
}
