package com.RestaurantApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restauranttables")
public class Tables {

	@Id
	@Column(name="table_no")
	private int table_no;
	@Column(name="table_seats")
	private int table_seats;
	@Column(name="table_state")
	private String table_state;
	public Tables() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tables(int table_no, int table_seats, String table_state) {
		super();
		this.table_no = table_no;
		this.table_seats = table_seats;
		this.table_state = table_state;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	public int getTable_seats() {
		return table_seats;
	}
	public void setTable_seats(int table_seats) {
		this.table_seats = table_seats;
	}
	public String getTable_state() {
		return table_state;
	}
	public void setTable_state(String table_state) {
		this.table_state = table_state;
	}
	
}
