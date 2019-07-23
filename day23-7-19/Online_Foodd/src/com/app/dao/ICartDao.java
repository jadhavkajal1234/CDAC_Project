package com.app.dao;

import java.util.List;


import com.app.pojos.Product;

public interface ICartDao {
	  public List<Product> getProduct();
	 String addProduct (Product newProduct);
	  public void removeProduct(int productId);
}
