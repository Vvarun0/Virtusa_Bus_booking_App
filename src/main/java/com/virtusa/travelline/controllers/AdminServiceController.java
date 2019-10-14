package com.virtusa.travelline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.travelline.models.City;
import com.virtusa.travelline.models.Route;
import com.virtusa.travelline.models.Service;
import com.virtusa.travelline.models.State;
import com.virtusa.travelline.models.User;
import com.virtusa.travelline.repositories.ServiceRepository;
import com.virtusa.travelline.services.RouteService;
import com.virtusa.travelline.services.ServiceService;
import com.virtusa.travelline.services.UserService;

@Controller
public class AdminServiceController {

	@Autowired
	private ServiceService serviceService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RouteService routeService;
	
	@PostMapping(value="/addNewservice")
	public  String addService(@ModelAttribute com.virtusa.travelline.models.Service service ,@ModelAttribute City city,@ModelAttribute State state,@RequestParam("trip") String trip,Model model)
	{
		User user=userService.getUserById("admin@admin.com");
		Route route = routeService.getRouteById(Integer.parseInt( trip.split("-")[0]));
		service.setRoute(route);
		service.setUser(user);
		serviceService.addService(service);
		model.addAttribute("message","Service Added Successfully!!");
		return "addservice";//addservice button in the admin home page
	}
	
	@RequestMapping(value="/modifyOldservice")
	public  String modifyService(@ModelAttribute com.virtusa.travelline.models.Service newService,Model model)
	{
		Service oldService = serviceService.getServiceById(newService.getServiceId());
		oldService.setDepartureTime(newService.getDepartureTime());
		oldService.setJourneyTime(newService.getJourneyTime());
		serviceService.updateService(oldService);
		model.addAttribute("message","Service Modified Successfully!!");
		return "redirect:/modifyservice";//modifyservice button in the admin home page
	}
	
	@PostMapping("/getservicebyid")
	public  String getServiceById(@RequestParam("serviceId") String trip,Model model)
	{
		List<String> modifyService = new ArrayList<String>();
		Service values = serviceService.getServiceById(trip);
		modifyService.add(values.getDepartureTime());
		modifyService.add(values.getJourneyTime());
		modifyService.add(values.getServiceId());
		modifyService.add(values.getRoute().getRouteId()+"");
		modifyService.add(values.getUser().getEmail());
		
		model.addAttribute("services",modifyService);
		return "getservicebyid";//deleteservice button in the admin home page
	}
	
}
