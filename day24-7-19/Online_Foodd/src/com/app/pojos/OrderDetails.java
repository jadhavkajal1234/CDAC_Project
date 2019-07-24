package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetails")
public class OrderDetails {
	private Integer orderDetailsId;
	private String paymentStatus;
	private int Quantity;
	
	private Order1 oid;
	
	private Product pid;

	public OrderDetails( String paymentStatus, int quantity) {
	
		this.paymentStatus = paymentStatus;
		this.Quantity = quantity;
		
	}
	

	public OrderDetails() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@ManyToOne
	@JoinColumn(name="FOrderId")
	public Order1 getOid() {
		return oid;
	}

	public void setOid(Order1 oid) {
		this.oid = oid;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fProductId")	
	public Product getPid() {
		return pid;
	}

	public void setPid(Product pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", paymentStatus=" + paymentStatus + ", Quantity="
				+ Quantity + ", oid=" + oid + ", pid=" + pid + "]";
	}

	
	
	
}
