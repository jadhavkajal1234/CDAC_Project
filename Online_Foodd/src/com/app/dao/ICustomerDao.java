package com.app.dao;

import com.app.pojos.Customer;

public interface ICustomerDao {
	Customer validateCustomer(String email, String pass);
}
