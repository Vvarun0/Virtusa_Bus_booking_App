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
import javax.persistence.Table;

@Entity
@Table(name= "Bus_tbl")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Bus_Id" )
	private int busId;
	
	@Column(name= "Bus_Type" ,nullable=false)
	private String busType;
	@Column(name ="Company" ,nullable=false)
	private String company;
	
	@Column(name="Capacity",nullable=false)
	private int capacity;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "Service_Id",nullable=false) 
	private Service service;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	 
}