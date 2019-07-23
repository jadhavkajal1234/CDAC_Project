package com.app.dao;

import java.util.List;
import com.app.pojos.*;
public interface IAdminDao {
	List<Customer> listCustomer();
	
	
	
	//String registerCustomer(Customer c);
	//String addCustomer(Customer c);
	String deleteCustomer(int id);
//	Customer getCustomerDetails(int id);
	//Customer updateCustomerDetails(Customer c);
	
	String addProduct(Product p);
	String deleteProduct(int id);
    Product updateProduct(Product p);
   // Product getProductDetails(int id);
    
    String addRestaurant(Restaurant r);
	String deleteRestaurant(int id);
	Restaurant updateRestaurant(Restaurant r);
	//Restaurant getRestaurantDetails(int id);
	
	
	//Order1 getOrderDetails(int id);
    
	
}
