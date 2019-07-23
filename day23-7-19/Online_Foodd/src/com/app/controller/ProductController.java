package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.service.ICustomerService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ICustomerService service;
	
@RequestMapping(method= RequestMethod.GET)
public String index(ModelMap modelmap) {
	modelmap.put("Product_list",service.listProduct());
	return "index";
}
}
