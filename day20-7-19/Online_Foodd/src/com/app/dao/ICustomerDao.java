package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.pojos.Restaurant;

public interface ICustomerDao {
	Customer validateCustomer(String email, String pass);
	String registerCustomer(Customer c);
	Customer updateCustomerDetails(Customer detacheCustomer );
	String addCustomer(Customer c);
	Customer getCustomerDetails(int id);
	 Product getProductDetails(int id);
	 Restaurant getRestaurantDetails(int id);
	 Order1 getOrderDetails(int id);
	 List<Product> getCartDetails(List<Integer> productId) ;
	 
	 List<Order1> listOrder();
		List<Product> listProduct();
		List<Restaurant> listRestaurant();
		
}
