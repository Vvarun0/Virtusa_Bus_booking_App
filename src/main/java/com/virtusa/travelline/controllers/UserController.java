package com.virtusa.travelline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.travelline.models.Booking;
import com.virtusa.travelline.models.Bus;
import com.virtusa.travelline.models.Passenger;
import com.virtusa.travelline.models.Payment;
import com.virtusa.travelline.models.Route;
import com.virtusa.travelline.models.Service;
import com.virtusa.travelline.services.BookingService;
import com.virtusa.travelline.services.BusService;
import com.virtusa.travelline.services.CityService;
import com.virtusa.travelline.services.PassengerService;
import com.virtusa.travelline.services.PaymentService;
import com.virtusa.travelline.services.RouteService;
import com.virtusa.travelline.services.ServiceService;

@Controller
public class UserController {
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ServiceService serviceService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PassengerService passengerService;
	
	
	@Autowired
	private BusService busService;
	//operations on user tab - userhome,bookTicket,bookedTickets,feedback
	private String seatNumbers="";
	
		@RequestMapping(value="/userhome")
		public  String userHome()
		{
			return "userhome";//homebutton in the user home page
		}
		
		@RequestMapping(value="/bookticket")
		public  String bookTicket(@ModelAttribute com.virtusa.travelline.models.Route route,Model model)
		{
			List<Route> routes = routeService.getAllRoute();
			List<String> source = new ArrayList<String>();
			for(Route route1:routes)
			{
				String city = route1.getRouteId()+"-"+cityService.getCity(route1.getSource());
				 city =city+"-"+cityService.getCity(route1.getDestination());
				source.add(city);
			}
			model.addAttribute("sources", source);
			
			return "bookticket";//bookTicket button in the user home page
		}
		
		@RequestMapping(value="/busserviceselection")
		public  String busServiceSelection(@ModelAttribute com.virtusa.travelline.models.Bus bus,Model model)
		{
			List<Bus> buses = busService.getAllBus();
			List<String> source = new ArrayList<String>();
			for(Bus i:buses)
			{
				String details = i.getCompany()+"-"+i.getBusType();
				 
				source.add(details);
			}
			model.addAttribute("sources", source);
			//model.addAttribute(arg0, arg1)
			return "busserviceselection";//bookTicket button in the user home page
		}
		
		
		@RequestMapping(value="/selectseat")
		public  String selectSeat(@ModelAttribute Booking booking, Model model)
		{
			Booking lastElement = bookingService.getAllBooking().get(bookingService.getAllBooking().size()-1);
			model.addAttribute("bookingid", lastElement.getBookingId());
			model.addAttribute("fare", lastElement.getFare());
			model.addAttribute("doj", lastElement.getDateOfJourney());
			
			int seatsFilled = passengerService.remainingSeats(bookingService.getBookingById(lastElement.getBookingId()).getService().getServiceId()),capacity=40;
			String nextSeats = "";
			int i =0;
			if(seatsFilled+lastElement.getNoOfPassengers() <= capacity)
			while(i++<lastElement.getNoOfPassengers()) 
				nextSeats+=++seatsFilled+"-";
			else
			{
				model.addAttribute("message", "no seats available");
				return "selectseat";
			}
			nextSeats=nextSeats.substring(0, nextSeats.length()-1);
			model.addAttribute("seatNumbers", nextSeats);
			return "selectseat";//bookedtickets button in the user home page
		}
		
		@RequestMapping(value="/feedback")
		public  String feedback()
		{
			return "feedback";//feedback button in the user home page
		}
		
		@RequestMapping(value="/logoutuser")
		public  String logoutUser()
		{
			return "logoutuser";//user delete operations (delete) button in the admin home page
		}
		@RequestMapping(value="/contactus")
		public  String contactus()
		{
			return "contactus";//homebutton in the user home page
		}
		@RequestMapping(value="/gallary")
		public  String gallary()
		{
			return "gallary";//homebutton in the user home page
		}
		
		@RequestMapping(value="/viewscheduleuser")
		public  String viewScheduleUser(Model model)
		{
			
			List<Service> services = serviceService.getAllService();
			List<String> values = new ArrayList<String>();

			model.addAttribute("schedules", services);
			return "viewscheduleuser";//view schedule button in the admin home page
			
		}
		
		
		@RequestMapping(value="/passengerdetail")
		public  String passengerDetail(@RequestParam(value="cilentName",required=false) String clientName,@RequestParam(value="seatNumbers",required=false) String seatNumbers,Model model)
		{ 
			model.addAttribute("passenger", new Passenger());
			this.seatNumbers=seatNumbers;
			model.addAttribute("seats", seatNumbers.split("-").length); 
			return "passengerdetail";//bookedtickets button in the user home page
		}
		
		
		@RequestMapping(value="/payment")  
		public  String paymentDetail(@RequestParam(value="passengerName",required=false) String passengerName,Model model)
		{
			//System.out.println("payment details ="+passengerName);/*passenger.getPassengerName().split(",")[0]);*/
			Booking booking = bookingService.getAllBooking().get(bookingService.getAllBooking().size()-1);
			String[] passengerNames = passengerName.split(",");
			Passenger newPassenger ;
			for(int i=0;i<passengerNames.length;i++)
			{
				newPassenger = new Passenger();
				newPassenger.setPassengerName(passengerNames[i]);
				newPassenger.setSeatNumber(Integer.parseInt(seatNumbers.split("-")[i]));
				newPassenger.setBooking(booking);
				passengerService.addPassenger(newPassenger);
			}
			//System.out.println(this.seatNumbers);
			return "payment";//bookedtickets button in the user home page
		}
		
		@PostMapping("/paymentsuccess")
		public String paymentSuccess(@ModelAttribute Payment payment,Model model)
		{
			payment.setCardType("credit");//only credit cards are accepted as per documentation
			payment.setBooking(bookingService.getAllBooking().get(bookingService.getAllBooking().size()-1));
			paymentService.addpayment(payment);
			model.addAttribute("passengerdetails",paymentService.getpaymentById(payment.getPaymentId()));
			return "paymentsuccess";
		}
	}