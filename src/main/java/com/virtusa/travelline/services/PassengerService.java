package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.Passenger;
import com.virtusa.travelline.repositories.PassengerRepository;

@Service
public class PassengerService {
	@Autowired
	private PassengerRepository passengerRepository;
	
	public List<Passenger> getAllPassenger() {
		return passengerRepository.findAll();
	}

	public Passenger getPassengerById(int passengerId) {
		return passengerRepository.findById(passengerId).orElse(null);
	}

	public Passenger addPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	public boolean deletePassenger(int passengerId) {
		boolean status = false;
		passengerRepository.deleteById(passengerId);
		status = true;
		return status;
	}

	public Passenger updatePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}
	
	public int remainingSeats(String serviceId) {
		return passengerRepository.remainingseats(serviceId);
	}
}
