package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.repositories.ServiceRepository;

@Service
public class ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;
	
	public List<com.virtusa.travelline.models.Service> getAllService() {
		return serviceRepository.findAll();
	}

	public com.virtusa.travelline.models.Service getServiceById(String serviceId) {
		return serviceRepository.findById(serviceId).orElse(null);
	}

	public com.virtusa.travelline.models.Service addService(com.virtusa.travelline.models.Service service) {
		return serviceRepository.save(service);
	}

	public boolean deleteService(String serviceId) {
		boolean status = false;
		serviceRepository.deleteById(serviceId);
		status = true;
		return status;
	}

	public com.virtusa.travelline.models.Service updateService(com.virtusa.travelline.models.Service service) {
		return serviceRepository.save(service);
	}

	public String getServiceIdForBooking(int trip) {
		return serviceRepository.getServiceIdForBooking(trip);
	}
}
