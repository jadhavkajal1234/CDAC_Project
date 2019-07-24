package com.app.service;

import java.util.List;

import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.pojos.Customer;

import com.app.pojos.OrderDetails;
import com.app.pojos.Restaurant;

public interface IAdminService {
	List<Customer> listCustomer();
	List<Product> listProduct();
	List<Restaurant> listRestaurant();
	
	Product getProductDetails(int id);
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
	Restaurant getRestaurantDetails(int id);
    
	
	
	
	
	public Order1 CustomerEntryFromOrders(Customer c);
	public List<OrderDetails> getCart(Order1 orderInTable);
	public Order1 checkCusExisting(Customer c);
	public Product getSelectedProduct(int cartProductId);
	public void addOrder(Order1 o);
	public void addOrderDetails(OrderDetails od);
	
	public Product getSingleProduct(int pid);
}
