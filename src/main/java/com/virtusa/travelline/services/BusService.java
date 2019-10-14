package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.Bus;
import com.virtusa.travelline.repositories.BusRepository;

@Service
public class BusService {

	@Autowired
	private BusRepository busRepository;
	
	public List<Bus> getAllBus() {
		return busRepository.findAll();
	}

	public Bus getBusById(int busId) {
		return busRepository.findById(busId).orElse(null);
	}

	public Bus addBus(Bus bus) {
		return busRepository.save(bus);
	}

	public boolean deleteBus(int busId) {
		boolean status = false;
		busRepository.deleteById(busId);
		status = true;
		return status;
	}

	public Bus updateBus(Bus bus) {
		return busRepository.save(bus);
	}
	
	public int getCapacity(String serviceId) {
		return busRepository.getBusCapacity(serviceId);
	}
}