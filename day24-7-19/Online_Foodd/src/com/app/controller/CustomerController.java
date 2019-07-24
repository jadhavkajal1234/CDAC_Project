package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.OrderDetails;

import com.app.pojos.Product;

import com.app.pojos.Order1;
import com.app.pojos.Customer;

//import com.app.pojos.ShoppingCart;
import com.app.service.ICustomerService;
import com.app.service.IAdminService;

//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
//@RestController
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	@Autowired
	private IAdminService servicee;
	Double price=0.0; 
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
		return "redirect:/customer/login";
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
				
			if(email.equals("admin@gmail.com")&& pass.equals("1234")) {
				return "redirect:/admin/list_cust";
			}
			else {
				
				Customer c = service.validateCustomer(email, pass);
				// login successful -- chk role
				// customer --redicrect clnt to details page
				//add status in flash map to be remembered till next request
				flashMap.addFlashAttribute("status", "Successful Login , ");
				//store user dtls under session scope
				hs.setAttribute("cust_dtls",c);
					return "redirect:/customer/restro_list";
			} 
			}
			
			catch (RuntimeException e) {
				System.out.println("err in process login form " + e);
				// invalid login ---forward the clnt to login form highlighted with errs
				// add error mesg as a model attr
				map.addAttribute("status", "Invalid Login , Pls retry....");
				return "customer/login";
			}
			
		}
		@GetMapping("/update")
		public String showUpdateForm(@RequestParam int cid,Model map)
		{
				System.out.println("in show update form "+cid);
				map.addAttribute("customer",service.getCustomerDetails(cid));
				System.out.println(map);
				return "customer/update";
		}
		//request handling method for processing vendor updation form
				@PostMapping("/update")
				public String processUpdateForm(Customer id,RedirectAttributes attrs)
				{
						System.out.println("in process update form "+id);
						attrs.addFlashAttribute("status", service.updateCustomerDetails(id));
						return "redirect:/customer/restro_list";
		
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
					
					System.out.println("in list Product "+map);
					map.addAttribute("product_list", service.listProduct());
					return "customer/product_list";
				}
	//***********************			
				@GetMapping("/backlist")
				public String  forwardPage()
				{
					return "redirect:/customer/login";
				}
				
				@GetMapping("/bill")
				String processToBill(HttpSession hs)
				{
					System.out.println("in bill");
					
					@SuppressWarnings("unchecked")
					List<OrderDetails> cartObjects=(List<OrderDetails>)hs.getAttribute("cart_dtls");
					
					double bill=0;
					double discount=0;
					for (OrderDetails orderDetails : cartObjects) {
						
						bill= bill +orderDetails.getPid().getPrice();
						
					}
					hs.setAttribute("bill", bill);
					
					return"customer/bill";
				}	
				
//**************8
				@GetMapping("/cart")
				public String cartDisplay(HttpSession hs,RedirectAttributes flashmap)
				{
					Customer c= (Customer) hs.getAttribute("cust_dtls");
					System.out.println("customer = "+c.getName()+"  email = "+c.getEmail());
					if(hs.getAttribute("cust_dtls")==null)
					{
						flashmap.addAttribute("cart", "Please login First");
						return "customer/login";
					}
					Order1 OrderInTable=servicee.CustomerEntryFromOrders(c);
					List<OrderDetails> cartObjects=servicee.getCart(OrderInTable);
					hs.setAttribute("cart_dtls", cartObjects);
					
					return "customer/cartPage";
				}
				
				
				//error over here with products casting on line 95
				@GetMapping("/addToCart/{id}")
				public String addToCart(HttpSession hs,@PathVariable("id") int cartProductId,RedirectAttributes flashmap,Model map)
				{
					System.out.println();
					System.out.println("inside add to cart method of controller");
					System.out.println(hs.getAttribute("cust_dtls"));
					Customer c=(Customer) hs.getAttribute("cust_dtls");//customer details in c
					System.out.println();
					System.out.println();
					
					//set product details in session
					Product prop=servicee.getSingleProduct(cartProductId);
					hs.setAttribute("prop_cartdetails", prop);
					
					if(c!=null)//if user is logged in
					{
						System.out.println(hs.getAttribute("product_list")); //show all products
						System.out.println();
						System.out.println();
						System.out.println(cartProductId);//selected product id
						//now check if entry already present in Orders table
						if(servicee.checkCusExisting(c)==null)
						{
							System.out.println("customer entry not present in Orders table");
							Order1 o=new Order1();
							o.setCustomerId(c);
							o.setOrderDate(new Date());
							o.setStatus("pending");
						//o.setTotalOrder(100);
						price= price + prop.getPrice();
						o.setTotalOrder(100);
							servicee.addOrder(o);
						}
						
						System.out.println("customers Entry present in Orders table");
						//this part will be executed in both the cases whether order Entry of customer is already present or not
						//get order id since the customer's entry is already present in Orders table
						price= price + prop.getPrice();

						Order1 OrderInTable=servicee.CustomerEntryFromOrders(c);
						OrderDetails od=new OrderDetails();
						od.setOid(OrderInTable);
						//get Product that is select to enter in OrderDetails
						Product product=servicee.getSelectedProduct(cartProductId);
						od.setPid(product);
						od.setPaymentStatus("pending");
					
						od.setQuantity(1);
						servicee.addOrderDetails(od);
						
						map.addAttribute("cart_info", "Item Added To Cart");
						//to get all cart objects of particular user from Order details table
						List<OrderDetails> cartObjects=servicee.getCart(OrderInTable);
						hs.setAttribute("cart_dtls", cartObjects);
						return "customer/cartPage";
					}
					
					return ("redirect:login?cartProductId="+cartProductId);	
				}
				
				@RequestMapping("/logout")
				public String logoutUser(HttpSession hs,HttpServletResponse response,HttpServletRequest request)
				{
					System.out.println("inside logout method of controller");
					System.out.println(hs.getAttribute("cust_dtls"));
					System.out.println(hs.getAttribute("cart_dtls"));
					hs.invalidate();
					return "redirect:/index.jsp";
				}
			}
