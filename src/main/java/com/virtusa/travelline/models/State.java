package com.virtusa.travelline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="State_tbl")
public class State {
	
	@Id
	@Column(name="State_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stateId;
	@Column(name="State_Name",nullable=false)
	private String stateName;
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
