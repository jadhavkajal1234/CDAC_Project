package com.app.pojos;

import java.util.List;

public class ShoppingCart {
	private String[] item;
	private List<Product> products;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setItem(String[] item) {
		this.item = item;
	}
	
	public String[] getItem() {
		return item;
	}
}
