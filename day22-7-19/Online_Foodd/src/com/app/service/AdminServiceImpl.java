package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Customer;

import com.app.pojos.Order1;
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
