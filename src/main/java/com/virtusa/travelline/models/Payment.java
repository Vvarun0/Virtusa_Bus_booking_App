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
@Table(name= "Payment_tbl")
public class Payment {

	@Id
	@Column(name = "Payment_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	
	@Column(name ="Card_Type", nullable=false)
	private String cardType;
	
	
	  @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	  @JoinColumn(name= "Booking_Id",nullable=false) 
	  private Booking booking;


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	  
	
	 
}
