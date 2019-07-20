package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Customer;
@Repository

public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private SessionFactory sf;
	
	public CustomerDaoImpl() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	
	
	@Override
	public Customer validateCustomer(String email, String pass) {
		String jpql = "select c from Customer c  where c.email=:em and c.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("em", email).setParameter("pa", pass)
				.getSingleResult();
	}


	@Override
	public String registerCustomer(Customer c) {
		sf.getCurrentSession().persist(c);
		return "Customer registration successful with ID" + c.getId();
	}


	@Override
	public Customer updateCustomerDetails(Customer c) {
		sf.getCurrentSession().update(c);
		return c;
	}


	
	
}
