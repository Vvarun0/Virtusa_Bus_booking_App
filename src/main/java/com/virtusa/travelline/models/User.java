package com.virtusa.travelline.models;

import java.util.List;

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
@Table(name ="User_tbl")
public class User {

	@Id
	@Column(name="Email_Id" ,nullable=false)
	private String email;
	
	@Column(name="User_Name" ,nullable=false)
	private String userName;
	@Column(name="Password" ,nullable=false)
	private String password;
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
	 * 
	 * @JoinColumn(name="role") Role role;
	 */
	/*
	 * public Role getRole() { return role; } public void setRole(Role role) {
	 * this.role = role; }
	 */
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
    private List<Role> role;
	

	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
}
