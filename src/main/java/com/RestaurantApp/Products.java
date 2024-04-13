package com.RestaurantApp;


import jakarta.persistence.Entity;


import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="ProductsData")
public class Products {
	
	@Id
    private int product_id;
	
    private String product_name;
    private double product_rate;
    private String product_desc;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Products(int product_id, String product_name, double product_rate, String product_desc) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_rate = product_rate;
		this.product_desc = product_desc;
	}



	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", product_rate="
				+ product_rate + ", product_desc=" + product_desc + "]";
	}

	public int getProduct_id() {
		return product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_rate() {
		return product_rate;
	}
	public void setProduct_rate(int product_rate) {
		this.product_rate = product_rate;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
    
    

}
