package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.travelline.models.Passenger;

public interface PassengerRepository extends  JpaRepository<Passenger, Integer>{
	
	@Query("SELECT count(p.seatNumber) FROM Passenger p WHERE p.booking.service.serviceId = :source")
	public int remainingseats(@Param("source") String serviceId);

}
