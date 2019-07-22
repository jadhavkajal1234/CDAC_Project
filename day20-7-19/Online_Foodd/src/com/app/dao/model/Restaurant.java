package com.app.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Restaurant {
	private Integer restaurantId;
	
	@NotEmpty(message=" Name must be suplied")
	private String name;
	@NotEmpty(message=" Address must be suplied")
	private String address;
	private List<Product> products=new ArrayList<>();
	private List<Order1> orders=new ArrayList<>();
	public Restaurant() {
		
	}
	
	
	public Restaurant( String name, String address) {
		
		
		this.name = name;
		this.address = address;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Order1> getOrders() {
		return orders;
	}
	public void setOrders(List<Order1> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + "]";
	}
	
}
