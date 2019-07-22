package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Customer;
import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.pojos.Restaurant;
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
	public Customer updateCustomerDetails(Customer detacheCustomer) {
		sf.getCurrentSession().update(detacheCustomer);
		return detacheCustomer;
	}


	@Override
	public String addCustomer(Customer c) {
		sf.getCurrentSession().save(c);
		return "Customer added with ID "+c.getId();
	}


	@Override
	public Customer getCustomerDetails(int id) {
		return sf.getCurrentSession().get(Customer.class, id);
	}
	@Override
	public Product getProductDetails(int id) {
		return sf.getCurrentSession().get(Product.class, id);
	}
	@Override
	public Restaurant getRestaurantDetails(int id) {
		return sf.getCurrentSession().get(Restaurant.class, id);
	}

	@Override
	public Order1 getOrderDetails(int id) {
		return sf.getCurrentSession().get(Order1.class, id);
		
	}

	@Override
	public List<Order1> listOrder() {
		String jpql="select o from Order1 o";
		
		return sf.getCurrentSession().createQuery(jpql, Order1.class).getResultList();
	}

	@Override
	public List<Product> listProduct() {
       String jpql="select p from Product p";
		
		return sf.getCurrentSession().createQuery(jpql, Product.class).getResultList();
	}

	@Override
	public List<Restaurant> listRestaurant() {
		 String jpql="select r from Restaurant r";
			
			return sf.getCurrentSession().createQuery(jpql,Restaurant.class).getResultList();
	}


	@Override
	public List<Product> getCartDetails(List<Integer> productId) {
		
		String jpql = "select p from Product p where p.productId in (:ids)";
		
		return sf.getCurrentSession().createQuery(jpql, Product.class).getResultList();
				
	}




	
	
}
