package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Item;
import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.service.ICustomerService;
@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	private ICustomerService service;

	@RequestMapping(value="/addnow/{id}")
public String addnow(@PathVariable(value="id") int id,HttpSession session) {
	if(session.getAttribute("cart")==null) {
		List<Item> cart=new ArrayList<Item>();
		cart.add(service.getItemDetails(id));
		session.setAttribute("cart", cart);
	}
	else
	{
		List<Item> cart =(List<Item> )session.getAttribute("cart");
		int index =isExisting(id,session);
		if(index==-1)
			cart.add (service.getItemDetails(id));
		else {
			int quantity=cart.get(index).getQuantity() 	+1;
			cart.get(index).setQuantity(quantity);
		}
		session.setAttribute("cart", cart);
	}
	return "product_list";
}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") int id,HttpSession session) {
		List<Item> cart =(List<Item> )session.getAttribute("cart");
		int index =isExisting(id,session);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "addcart";
		
	}
	
	private int isExisting(int id,HttpSession session) {
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		for(int i=0;i<cart.size();i++)
			if(cart.get(i).getProducts().getId()==id)
				return i;
		return -1;
	}
}

