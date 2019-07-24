package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Customer;

import com.app.pojos.Order1;
import com.app.pojos.OrderDetails;
import com.app.pojos.Product;
import com.app.pojos.Restaurant;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminDao dao;
	@Override
	public List<Customer> listCustomer() {
		return dao.listCustomer();
	}

	

	/*@Override
	public String registerEmployee(Employee e) {
		return dao.registerEmployee(e);
	}*/

	
	/*@Override
	public String registerCustomer(Customer c) {
		return dao.registerCustomer(c);
	}*/

	/*@Override
	public String addCustomer(Customer c) {
		return dao.addCustomer(c);
	}*/

	@Override
	public String deleteCustomer(int id) {
		return dao.deleteCustomer(id);
	}

	@Override
	public String addProduct(Product p) {
		return dao.addProduct(p);
	}

	@Override
	public String deleteProduct(int id) {
		return dao.deleteProduct(id);
	}

	@Override
	public Product updateProduct(Product p) {
		return dao. updateProduct(p);
	}

	

	@Override
	public String addRestaurant(Restaurant r) {
		return dao.addRestaurant(r);
	}

	@Override
	public String deleteRestaurant(int id) {
		return dao.deleteRestaurant(id);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r) {
		return dao.updateRestaurant(r);
	}



	@Override
	public List<Product> listProduct() {
		
		return dao.listProduct();
	}



	@Override
	public Product getProductDetails(int id) {
		return dao.getProductDetails(id);
	}



	@Override
	public List<Restaurant> listRestaurant() {
		return dao.listRestaurant();
	}



	@Override
	public Restaurant getRestaurantDetails(int id) {
		 return dao.getRestaurantDetails(id);
	}



	@Override
	public Order1 CustomerEntryFromOrders(Customer c) {
		return dao.CustomerEntryFromOrders(c);
	}



	@Override
	public List<OrderDetails> getCart(Order1 orderInTable) {
		return dao.getCart(orderInTable);
	}



	@Override
	public Order1 checkCusExisting(Customer c) {
		return dao.checkCusExisting(c);
	}



	@Override
	public Product getSelectedProduct(int cartProductId) {
		return dao.getSelectedProduct(cartProductId);
	}



	

	@Override
	public void addOrderDetails(OrderDetails od) {
		dao.addOrderDetails(od);
		
	}



	@Override
	public Product getSingleProduct(int pid) {
		return dao.getSingleProduct(pid);
	}



	@Override
	public void addOrder(Order1 o) {
		dao.addOrder(o);
		
	}



	

	/*
	@Override
	public Customer getCustomerDetails(int id) {
		return dao.getCustomerDetails(id);
	}*/

	/*
	@Override
	public Customer updateCustomerDetails(Customer c) {
		return dao.updateCustomerDetails(c);
	}*/

}
