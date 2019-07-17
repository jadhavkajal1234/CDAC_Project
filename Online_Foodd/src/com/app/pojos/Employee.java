package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="Employee")
public class Employee {
	
	private Integer id;
	
	@NotEmpty(message="Name must be suplied")
	private String name;
	
	@NotEmpty(message="Email must be suplied")
	private String email;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Blank or invalid pwd")
	private String password;
	
	@NotEmpty
	@Length(min=10,max=10)
	private String phonenumber;
	
	@NotEmpty(message="Role must be suplied")
	private String role;
	private List<Order1>orders=new ArrayList<>();
	
	
	public Employee() {
		
	}
	
	public Employee( String name, String email, String password, String phonenumber, String role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@OneToMany(mappedBy="employeeId",cascade=CascadeType.ALL)
	public List<Order1> getOrders() {
		return orders;
	}

	public void setOrders(List<Order1> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phonenumber=" + phonenumber + ", role=" + role + ", orders=" + orders + "]";
	}
	
	
	
	
}
