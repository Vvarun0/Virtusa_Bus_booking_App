package com.virtusa.travelline.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.travelline.models.City;
import com.virtusa.travelline.models.Role;
import com.virtusa.travelline.models.Route;
import com.virtusa.travelline.models.Service;
import com.virtusa.travelline.models.State;
import com.virtusa.travelline.models.User;
import com.virtusa.travelline.services.CityService;
import com.virtusa.travelline.services.RoleService;
import com.virtusa.travelline.services.RouteService;
import com.virtusa.travelline.services.ServiceService;
import com.virtusa.travelline.services.StateService;
import com.virtusa.travelline.services.UserService;

@Controller
public class AdminHomeController {
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ServiceService serviceService;
	
	//operations on admin tab - addadmin,addservice,modifyservice
	@RequestMapping(value="/adminhome")
	public  String adminHome()
	{
		return "adminhome";//homebutton in the admin home page
	}
	
	@RequestMapping(value="/addservice")
	public  String addService(@ModelAttribute com.virtusa.travelline.models.Route route,Model model)
	{
		List<Route> routes = routeService.getAllRoute();
		List<String> source = new ArrayList<String>();
		for(Route route1:routes)
		{
			String city = route1.getRouteId()+"-"+cityService.getCity(route1.getSource());
			 city =city+"-"+cityService.getCity(route1.getDestination());
			source.add(city);
		}
		model.addAttribute("sources", source);//this go to ui
		return "addservice";//addservice button in the admin home page
	}
	
	@RequestMapping(value="/modifyservice")
	public  String modifyService(@ModelAttribute Service services,Model model)
	{
		List<Service> service = serviceService.getAllService();
		model.addAttribute("services", service);//this go to ui 
		return "modifyservice";//modifyservice button in the admin home page
	}
	
	
	
	@RequestMapping(value="/addadmin")
	public  String addAdmin()
	{
		
		return "addadmin";//addadmin button in the admin home page
	}
	
	
	@RequestMapping(value="/viewfeedback")
	public  String viewFeedback()
	{
		return "viewfeedback";//view feedback button in the admin home page
	}
	
	@RequestMapping(value="/viewschedule")
	public  String viewSchedule(Model model)
	{
		
		List<Service> services = serviceService.getAllService();
		List<String> values = new ArrayList<String>();
		
		model.addAttribute("schedules", services);
		return "viewschedule";//view schedule button in the admin home page
		
	}
	
	@RequestMapping(value="/logoutadmin")
	public  String logoutAdmin()
	{
		return "redirect:/";//another controller
		//user delete operations (delete) button in the admin home page 
	}
}