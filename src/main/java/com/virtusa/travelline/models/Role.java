package com.virtusa.travelline.models;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role_tbl")
public class Role 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="Role_Id")
	private int roleId;
	
	@Column(name = "Role_Name",nullable=false)
	private String roleName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="User_Name",nullable=false)
	private User user;
	
		public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

		public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

		public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
