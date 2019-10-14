package com.virtusa.travelline.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Route_tbl")
public class Route {

	@Id
	@Column(name="Route_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int routeId;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "Source",nullable=false)
	//@Column(name="Source")
	private City source;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "Destination",nullable=false)
	private City destination;
	
	@Column(name="Distance",nullable=false)
	private int distance;
	
	@Column(name="Fare",nullable=false)
	private long fare;
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public City getSource() {
		return source;
	}
	public void setSource(City source) {
		this.source = source;
	}
	public City getDestination() {
		return destination;
	}
	public void setDestination(City destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public long getFare() {
		return fare;
	}
	public void setFare(long fare) {
		this.fare = fare;
	}
	
}
