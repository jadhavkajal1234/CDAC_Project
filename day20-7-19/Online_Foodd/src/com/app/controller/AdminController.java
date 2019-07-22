package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		public String deleteCustomer(RedirectAttributes flashMap,@RequestParam int id)
		{
			System.out.println("in delete customer "+id);
			flashMap.addFlashAttribute("status",service.deleteCustomer(id));
			return "redirect:/admin/list_cust";
		}
		
				
				
				
				
				
	
				
				
				
				
				
			
				
				
				
					
				
}
