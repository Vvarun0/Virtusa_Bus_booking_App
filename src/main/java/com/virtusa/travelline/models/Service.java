package com.virtusa.travelline.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Service_tbl")
public class Service {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Service_Id")
	private String serviceId;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name="Route_Id",unique = true,nullable=false)
	private Route route;
	
	@Column(name="Departure_Time" ,nullable=false)
	private String departureTime;
	@Column(name="Journey_Time" ,nullable=false)
	private String journeyTime;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "Email_Id",nullable=false) 
	private User user;


	public String getServiceId() {
		return serviceId;
	}


	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}


	public Route getRoute() {
		return route;
	}


	public void setRoute(Route route) {
		this.route = route;
	}


		public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getJourneyTime() {
		return journeyTime;
	}


	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

		
}