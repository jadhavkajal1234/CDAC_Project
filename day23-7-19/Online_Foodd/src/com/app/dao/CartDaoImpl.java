package com.app.dao;

import java.util.List;
import java.util.Vector;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.app.pojos.Customer;
import com.app.pojos.Order1;
import com.app.pojos.Product;

@Repository
@Transactional
public class CartDaoImpl implements ICartDao {
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public String addProduct(Product newProduct) {
		return null;

	}

	@Override
	public void removeProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
