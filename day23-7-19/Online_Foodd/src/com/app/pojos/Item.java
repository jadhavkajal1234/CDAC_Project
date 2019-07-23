package com.app.pojos;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Item")
public class Item {
	private int id;
	private Product products =new Product();
	private int quantity;
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(Product products, int quantity) {
		
		this.products = products;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [products=" + products + ", quantity=" + quantity + "]";
	}
	
	
	
}