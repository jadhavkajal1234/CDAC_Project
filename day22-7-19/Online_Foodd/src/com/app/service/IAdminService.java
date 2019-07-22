package com.app.service;

import java.util.List;

import com.app.pojos.Customer;

import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.pojos.Restaurant;

public interface IAdminService {
	List<Customer> listCustomer();
	
	
	//String registerCustomer(Customer c);
	//String addCustomer(Customer c);
	String deleteCustomer(int id);
	//Customer getCustomerDetails(int id);
	//Customer updateCustomerDetails(Customer c);
	
	String addProduct(Product p);
	String deleteProduct(int id);
    Product updateProduct(Product p);
   
    
    String addRestaurant(Restaurant r);
	String deleteRestaurant(int id);
	Restaurant updateRestaurant(Restaurant r);
	
    
}
