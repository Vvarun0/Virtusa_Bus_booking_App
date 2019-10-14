package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.travelline.models.Route;

public interface RouteRepository extends JpaRepository<Route, Integer>{

	@Query("SELECT p.fare FROM Route p WHERE p.routeId = :source")
	public int getFareForBooking(@Param("source") int routeId);
}
