package com.app.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Order1")
public class Order1 {
	private Integer  id;
	private Customer customerId;
	
	@NotEmpty(message=" Quantity_item must be suplied")
	private String quantityItem;
	@NotEmpty(message=" Quantity_order must be suplied")
	private String quantityOrder;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	private String deliveryStatus;
	private Restaurant restaurantId ;
	
	
	public Order1() {
		
	}

	






	public Order1(Customer customerId, String quantityItem, String quantityOrder,
			Date orderDate, String deliveryStatus, Restaurant restaurantId) {
		
		this.customerId = customerId;
		
		this.quantityItem = quantityItem;
		this.quantityOrder = quantityOrder;
		this.orderDate = orderDate;
		this.deliveryStatus = deliveryStatus;
		this.restaurantId = restaurantId;
	}








	




	public Order1(Integer id) {
		super();
		this.id = id;
	}








	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}



	


	public String getQuantityItem() {
		return quantityItem;
	}


	public void setQuantityItem(String quantityItem) {
		this.quantityItem = quantityItem;
	}


	public String getQuantityOrder() {
		return quantityOrder;
	}


	public void setQuantityOrder(String quantityOrder) {
		this.quantityOrder = quantityOrder;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
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
	
	
	@ManyToOne
	@JoinColumn(name="cust_id")
	@JsonIgnore
	public Customer getCustomerId() {
		return customerId;
	}




	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}




	@Override
	public String toString() {
		return "Order1 [id=" + id + ", customerId=" + customerId + ", quantityItem="
				+ quantityItem + ", quantityOrder=" + quantityOrder + ", orderDate=" + orderDate + ", deliveryStatus="
				+ deliveryStatus + ", restaurantId=" + restaurantId + "]";
	}

	
	
}
