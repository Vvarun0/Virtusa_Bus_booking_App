package com.virtusa.travelline.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name= "Booking_tbl")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Booking_Id")
	private int bookingId;
	
	@Column(name ="No_Of_Passengers", nullable=false)
	private int noOfPassengers;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="Date_Of_Journey", nullable=false)
	private LocalDate dateOfJourney;
	
	@Column(name="Fare",nullable=false)
	private long fare;
	
	
	  @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	  @JoinColumn(name= "Service_Id",nullable=false) 
	  private Service service;
	
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

		public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

		public long getFare() {
		return fare;
	}

	public void setFare(long fare) {
		this.fare = fare;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

}
