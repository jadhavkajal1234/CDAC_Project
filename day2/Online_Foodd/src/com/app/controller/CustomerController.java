package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	public CustomerController() {
		System.out.println("in cnstr " + getClass().getName());
	}
	
	// request handling method to show login form
		@GetMapping("/login")
		public String showLoginForm() {
			System.out.println("in show login form");
			return "customer/login";
		}
		
		// request handling method to process login form
		@PostMapping("/login")
		public String processLoginForm(@RequestParam String email, @RequestParam(name = "password") String pass,
				Model map,RedirectAttributes flashMap,HttpSession hs) {
			System.out.println("in process login form " + email + " " + pass+" "+map);
			// invoke service layer method for validation
			try {
				Customer c = service.validateCustomer(email, pass);
				// login successful -- chk role
				// customer --redicrect clnt to details page
				//add status in flash map to be remembered till next request
				flashMap.addFlashAttribute("status", "Successful Login , ");
				//store user dtls under session scope
				hs.setAttribute("cust_dtls",c);

				return "redirect:/admin/list_cust";
			} catch (RuntimeException e) {
				System.out.println("err in process login form " + e);
				// invalid login ---forward the clnt to login form highlighted with errs
				// add error mesg as a model attr
				map.addAttribute("status", "Invalid Login , Pls retry....");
				return "user/login";
			}
			
		}
	
	
}
