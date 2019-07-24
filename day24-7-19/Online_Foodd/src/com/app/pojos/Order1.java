package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Order1")
public class Order1 {
	private Integer  id;
	private Customer customerId;
	
	

	private int totalOrder;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	private String Status;
	private Restaurant restaurantId ;
	private List<OrderDetails> orderDetails=new ArrayList<>();
	
	public Order1() {
		
	}

	














	public Order1(Customer customerId, int totalOrder, Date orderDate, String status, Restaurant restaurantId) {
	
		this.customerId = customerId;
		this.totalOrder = totalOrder;
		this.orderDate = orderDate;
		Status = status;
		this.restaurantId = restaurantId;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
@JsonIgnore
	@OneToMany(mappedBy="oid",cascade=CascadeType.ALL)
public List<OrderDetails> getOrderDetails() {
	return orderDetails;
}

public void setOrderDetails(List<OrderDetails> orderDetails) {
	this.orderDetails = orderDetails;
}

public Date getOrderDate() {
		return orderDate;
	}


	

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="restaurant_id")
	//@JsonIgnore
	public Restaurant getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cust_id")
	//@JsonIgnore
	public Customer getCustomerId() {
		return customerId;
	}




	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}



	public int getTotalOrder() {
		return totalOrder;
	}




	public void setTotalOrder(int i) {
		this.totalOrder = i;
	}




	public String getStatus() {
		return Status;
	}

public void setStatus(String status) {
		Status = status;
	}



/*
@Override
public String toString() {
	return "Order1 [id=" + id + ", customerId=" + customerId + ", totalOrder=" + totalOrder + ", orderDate="
			+ orderDate + ", Status=" + Status + ", restaurantId=" + restaurantId + "]";
}


*/





}
















































