package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.pojos.Restaurant;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;
	@Override
	public Customer validateCustomer(String email, String pass) {
		
		return dao.validateCustomer(email, pass);
	}
	@Override
	public String registerCustomer(Customer c) {
		return dao.registerCustomer(c);
	}
	@Override
	public Customer updateCustomerDetails(Customer detacheCustomer) {
		return dao.updateCustomerDetails(detacheCustomer);
	}
	@Override
	public String addCustomer(Customer c) {
		return dao.addCustomer(c);
	}
	@Override
	public Customer getCustomerDetails(int id) {
		return dao.getCustomerDetails(id);
	}
	@Override
	public Product getProductDetails(int id) {
		return dao.getProductDetails(id);
	}
	@Override
	public Restaurant getRestaurantDetails(int id) {
		return dao.getRestaurantDetails(id);
	}

	@Override
	public Order1 getOrderDetails(int id) {
		return dao.getOrderDetails(id);
	}


	@Override
	public List<Order1> listOrder() {
		return dao.listOrder();
	}

	@Override
	public List<Product> listProduct() {
		return dao.listProduct();
	}

	@Override
	public List<Restaurant> listRestaurant() {
		return dao.listRestaurant();
	}
	@Override
	public List<Product> getCartDetails(List<Integer> productId) {
String jpql = "select p from Product p where p.productId in (:ids)";
		
		return dao.getCartDetails(productId);
	}

}
