package com.RestaurantApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="logindata")
public class LoginData {
    
	@Id
	@Column(name="SNO")
	private int id;
	
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private int password;
	
	private String name;
	private int contact_number;
	private String address;
	private String doj;
	private String designation;
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginData(int id, String username, int password, String name, int contact_number, String address, String doj,
			String designation) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.contact_number = contact_number;
		this.address = address;
		this.doj = doj;
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "LoginData [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", contact_number=" + contact_number + ", address=" + address + ", doj=" + doj + ", designation="
				+ designation + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact_number() {
		return contact_number;
	}
	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	
}
