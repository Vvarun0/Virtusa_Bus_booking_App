package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.Route;
import com.virtusa.travelline.repositories.RouteRepository;

@Service
public class RouteService {

	@Autowired
	private RouteRepository routeRepository;
	
	public List<Route> getAllRoute() {
		return routeRepository.findAll();
	}

	public Route getRouteById(int routeId) {
		return routeRepository.findById(routeId).orElse(null);
	}

	public Route addRoute(Route route) {
		return routeRepository.save(route);
	}

	public boolean deleteRoute(int routeId) {
		boolean status = false;
		routeRepository.deleteById(routeId);
		status = true;
		return status;
	}

	public Route updateRoute(Route route) {
		return routeRepository.save(route);
	}
	
	public int getFare(int routeId)
	{
		return routeRepository.getFareForBooking(routeId);
	}
}
