package com.app.service;

import com.app.pojos.Customer;

public interface ICustomerService {
	Customer validateCustomer(String email, String pass);
}
