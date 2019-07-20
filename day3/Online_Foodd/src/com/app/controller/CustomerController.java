package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	 //request handling method for showing reg form
	@GetMapping("/register")
	public String showRegForm(Customer c)
	{
		
		//User u=new User();getters;setters
	//map.addAttribute("customer",c);
		System.out.println("in show reg form "+c);
		return "customer/register";
	}
	//request handling method for processing reg form
	@PostMapping("/register") //=@RequestMapping + method=post
	public String processRegForm(@Valid Customer c,BindingResult result,RedirectAttributes flashMap)
	{
		//User u=new User(); getters / matching setters /
		//map.addAttribute("user",u)
		System.out.println("in process reg form "+c);//u -- transient POJO
		//chk P.L errs
		if(result.hasErrors())
		{
			System.out.println("P.L errs");
			//forward the clnt to reg form highlighted with errs
			return "customer/register";
		}
		flashMap.addFlashAttribute("status", service.registerCustomer(c));
		return "redirect:/admin/list_cust";
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
				return "customer/login";
			}
			
		}
		//request handling method for showing vendor updation form
		@GetMapping("/update")
		public String showUpdateFormForCust(@RequestParam int id,Model map)
		{
				System.out.println("in show update form "+id);
				map.addAttribute("Customer",service.updateCustomerDetails(c));
				System.out.println(map);
				return "customer/update";
		}
		//request handling method for user's logout
		@GetMapping("/logout")
		public String logoutUser(HttpSession hs,Model map,HttpServletResponse response,HttpServletRequest rq)
		{
			System.out.println("in customer logout");
			//save user details under req scope , retrieved from HS scope
			map.addAttribute("details", hs.getAttribute("cust_dtls"));
			//discard session
			hs.invalidate();
			//set refresh header ---home page
			response.setHeader("refresh", "5;url="+rq.getContextPath());
			return "customer/logout";
		}

	
}
