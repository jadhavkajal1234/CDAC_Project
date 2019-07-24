package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.Product;
import com.app.service.IAdminService;
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService service;
	
	//req handling method to display Customer dtls
		@GetMapping("/list_cust")
		public String listCustomer(Model map)
		{
			
			System.out.println("in list Customer "+map);
			map.addAttribute("cust_list", service.listCustomer());
			return "admin/list_cust";
		}
	
		//req handling method to delete customer dtls
		@GetMapping("/delete")
		public String deleteCustomer(RedirectAttributes flashMap,@RequestParam int vid)
		{
			System.out.println("in delete customer "+vid);
			flashMap.addFlashAttribute("status",service.deleteCustomer(vid));
			return "redirect:/admin/list_cust";
		}
	/*	@GetMapping("/add_prod")
		public String addProduct(RedirectAttributes flashMap)
		{
			System.out.println("in add product");
			flashMap.addFlashAttribute("status",service.addProduct(vid));
			return "redirect:/admin/list_product";
		}*/
		
		

//*******************************				
				
			@GetMapping("/list_restaurant")
			public String listRestaurant(Model map)
			{
				
				System.out.println("in list restaurant "+map);
				map.addAttribute("restaurant_list", service.listRestaurant());
				return "admin/list_restaurant";
			}	
			/*@GetMapping("/add_restro")
			public String add(RedirectAttributes flashMap,@RequestParam int vid)
			{
				System.out.println("in add product"+vid);
				flashMap.addFlashAttribute("status",service.addRestaurant(vid));
				return "redirect:/admin/list_cust";
			}*/
			@GetMapping("/restro_delete")
			public String deleteRestaurant(RedirectAttributes flashMap,@RequestParam int rid)
			{
				System.out.println("in delete Restaurant"+rid);
				flashMap.addFlashAttribute("status",service.deleteRestaurant(rid));
				return "redirect:/admin/list_restaurant";
			}
			@GetMapping("/update_restro")
			public String showUpdate(@RequestParam int rid,Model map)
			{
					System.out.println("in show update form "+rid);
					map.addAttribute("restaurant",service.getRestaurantDetails(rid));
					System.out.println(map);
					return "admin/list_restaurant";
			}
//*******************************				
			@GetMapping("/list_product")
			public String listProduct(Model map)
			{
				
				System.out.println("in list Product "+map);
				map.addAttribute("product_list", service.listProduct());
				return "admin/list_product";
			}			
					
					
			@GetMapping("/update")
			public String showUpdateForm(@RequestParam int vid,Model map)
			{
					System.out.println("in show update form "+vid);
					map.addAttribute("customer",service.getProductDetails(vid));
					System.out.println(map);
					return "admin/update";
			}
			//request handling method for processing vendor updation form
					@PostMapping("/update")
					public String processUpdateForm(Product vid,RedirectAttributes attrs)
					{
							System.out.println("in process update form "+vid);
							attrs.addFlashAttribute("status", service.updateProduct(vid));
							return "redirect:/admin/list_product";
			
					}		
		
					
				@GetMapping("/deleteProduct")
					public String deleteProduct(RedirectAttributes flashMap,@RequestParam int vid)
					{
						System.out.println("in delete product"+vid);
						flashMap.addFlashAttribute("status",service.deleteProduct(vid));
						return "redirect:/admin/list_product";
					}	
				
				
				
					
}
