package com.app.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.pojos.ShoppingCart;
import com.app.service.ICustomerService;

//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
//@RestController
@Controller
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

				return "redirect:/customer/restro_list";
			} catch (RuntimeException e) {
				System.out.println("err in process login form " + e);
				// invalid login ---forward the clnt to login form highlighted with errs
				// add error mesg as a model attr
				map.addAttribute("status", "Invalid Login , Pls retry....");
				return "customer/login";
			}
			
		}
		@GetMapping("/update")
		public String showUpdateForm(@RequestParam int id,Model map)
		{
				System.out.println("in show update form "+id);
				map.addAttribute("customer",service.getCustomerDetails(id));
				System.out.println(map);
				return "customer/update";
		}
		//request handling method for processing vendor updation form
				@PostMapping("/update")
				public String processUpdateForm(Customer u,RedirectAttributes attrs)
				{
						System.out.println("in process update form "+u);
						attrs.addFlashAttribute("status", service.updateCustomerDetails(u));
						return "redirect:/admin/list_cust";
		
				}
				//req handling method to display Customer dtls
				@GetMapping("/restro_list")
				public String listCustomer(Model map)
				{
					
					System.out.println("in list Restaurant "+map);
					map.addAttribute("restro_list", service.listRestaurant());
					return "customer/restro_list";
				}
				
				@GetMapping("/product_list")
				public String listProduct(Model map)
				{
					map.addAttribute("products", new ShoppingCart());
					System.out.println("in list Product "+map);
					map.addAttribute("product_list", service.listProduct());
					return "customer/product_list";
				}
				
				//ruko 
			/*	@GetMapping("/orderlist")
				public String  getOrderDetails(@RequestParam List<Integer> id,Model map)
				{
						System.out.println("in show orderform "+id);
						map.addAttribute("order",service.getCartDetails(id));
						System.out.println(map);
						return "customer/orderplaces";
				}*/
				/*@RequestMapping("/newcart")
				public String creatCart(@RequestParam int pid,HttpSession session,HttpServletRequest req,RedirectAttributes r) {
					session.setAttribute("cart", new ArrayList<Product>());
					
					Enumeration<String> attrs=session.getAttributeNames();
					while(attrs.hasMoreElements()) {
						String attr =(String)attrs.nextElement();
						System.out.println("***" +attr + session.getAttribute(attr));
					}
					Product p=service.getProductDetails(pid);
					session.setAttribute("Prdt_dtls", p);
					r.addAttribute("Msg", "Added to cart Success");
					return "redirect:/customer/product_list";
				}*/
			/*	@RequestMapping("/addcart")
				public String addToCart(@ModelAttribute("pdt") Product pdt,HttpSession session) {
					String  productIds =pdt.getName();
					  List<Product> cart=(List<Product>) session.getAttribute("cart");
					for(String productId:productIds) {
						Product p=service.getProductDetails(id);
						cart.add(p);
					}
					return "redirect:/customer/show cart";
				}*/
				
				@RequestMapping("/showcart")
				public String showCart( Model m, HttpSession session) {
				List<Product> cart=(List<Product>) session.getAttribute("cart");
					double sum=0.0;
					for(Product p:cart) {
						sum+=p.getPrice();
						
					}
					//m.addAttribute("bill", sum);
					session.setAttribute("cart", cart);
					return "redirect:/customer/showcart";
				}
				
				
				@GetMapping("/addcart")
				public String addToCart(@ModelAttribute("products") ShoppingCart products , HttpSession session){
					System.out.println("#########  " + products.getItem());
					for (String string : products.getItem()) {
						System.out.println("########################## "+string );
					}
					
					//session.getAttribute("cart"); yaha pe cart ko acess karo... yaha se book wala example refer karo .. usme he 
					// good I have now some office work
					return "redirect:/customer/showcart";
				}
	
			
	
}
