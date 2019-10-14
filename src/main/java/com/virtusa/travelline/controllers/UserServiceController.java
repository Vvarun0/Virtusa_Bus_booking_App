package com.virtusa.travelline.controllers;

import java.util.List;

import org.assertj.core.internal.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.travelline.models.Booking;
import com.virtusa.travelline.models.Passenger;
import com.virtusa.travelline.models.Service;
import com.virtusa.travelline.services.BookingService;
import com.virtusa.travelline.services.RouteService;
import com.virtusa.travelline.services.ServiceService;

@Controller
public class UserServiceController {

	@Autowired
	private ServiceService serviceService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RouteService routeService;
	
	@PostMapping("/details")
	public String firstStateBooking(@RequestParam("trip") String trip,Booking booking,Model model)
	{
		System.out.println(booking.getNoOfPassengers());
		System.out.println(booking.getBookingId());
		System.out.println(booking.getDateOfJourney());
		System.out.println(trip);
		System.out.println((serviceService).getServiceIdForBooking(Integer.parseInt(trip.split("-")[0])));
		System.out.println(routeService.getFare(Integer.parseInt(trip.split("-")[0])));
		System.out.println(routeService.getFare(Integer.parseInt(trip.split("-")[0]))*booking.getNoOfPassengers());
		
		booking.setFare(routeService.getFare(Integer.parseInt(trip.split("-")[0]))*booking.getNoOfPassengers());
		Service service = serviceService.getServiceById((serviceService).getServiceIdForBooking(Integer.parseInt(trip.split("-")[0])));
		booking.setService(service);

		Booking lastElement = bookingService.getAllBooking().get(bookingService.getAllBooking().size()-1);
		System.out.println(lastElement.getBookingId());
		model.addAttribute("bookingid", lastElement.getBookingId());
		bookingService.addBooking(booking); 
		return "redirect:/busserviceselection";
	}
	
	
}