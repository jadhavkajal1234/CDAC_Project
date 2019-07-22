package com.app.dao.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private Byte[] imageFile;
	private Restaurant restaurantId ;
	private String Type;
	private String[] items;
	
	public void setProducts(String[] products) {
		this.items = products;
	}
	
	public String[] getProducts() {
		return items;
	}
	
	public Product() {
		
	}
	
	
	public Product(String name, String description, Double price, Byte[] imageFile, Restaurant restaurantId,
			String type) {
	
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageFile = imageFile;
		this.restaurantId = restaurantId;
		Type = type;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}


@Lob
	public Byte[] getImageFile() {
		return imageFile;
	}



	public void setImageFile(Byte[] imageFile) {
		this.imageFile = imageFile;
	}


	@ManyToOne
	@JoinColumn(name="restaurant_id")
	public Restaurant getRestaurantId() {
		return restaurantId;
	}



	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}



	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imageFile=" + Arrays.toString(imageFile) + ", restaurantId=" + restaurantId + "]";
	}
	


}












