package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;
	@Override
	public Customer validateCustomer(String email, String pass) {
		
		return dao.validateCustomer(email, pass);
	}

}
