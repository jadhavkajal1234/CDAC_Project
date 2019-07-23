package com.app.pojos;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Product")
public class Product {
	private Integer id;
	@NotEmpty(message="Name must be suplied")
	private String name;
	@NotEmpty(message=" Description must be suplied")
	private String description;
	@NotNull
	private Double price;
	private Byte[] imageFile;
	private Restaurant restaurantId ;
	private String Type;
	private int quantity;
	public Product() {
		
	}
	
	
	public Product(String name, String description, Double price, Byte[] imageFile, Restaurant restaurantId,
			String type) {
	
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageFile = imageFile;
		this.restaurantId = restaurantId;
		this.Type = type;
		this.quantity=quantity;
	}
	



	public Product( String name, String description, Double price, String type) {
	
		this.name = name;
		this.description = description;
		this.price = price;
		
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
	@JsonIgnore
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
	


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imageFile=" + Arrays.toString(imageFile) + ", restaurantId=" + restaurantId + "]";
	}
	


}












