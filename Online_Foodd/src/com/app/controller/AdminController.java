package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.Employee;
import com.app.service.IAdminService;

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
	//req handling method to display Employee dtls
				@GetMapping("/list_emp")
				public String listEmployee(Model map)
				{
					System.out.println("in list Employee "+map);
					map.addAttribute("emp_list", service.listEmployee());
					return "admin/list_emp";
				}
				
				
				
				
	 //request handling method for showing reg form
				@GetMapping("/register_cust")
				public String showRegForm(Customer c)
				{
					//User u=new User();getters;setters
					//map.addAttribute("user",u);
					System.out.println("in show reg form "+c);
					return "admin/register_cust";
				}				
	//request handling method for processing reg form
				@PostMapping("/register_cust") //=@RequestMapping + method=post
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
						return "admin/register_cust";
					}
					flashMap.addFlashAttribute("status", service.registerCustomer(c));
					return "redirect:/admin/list_cust";
				}
				
				
				
				 //request handling method for showing reg form
				@GetMapping("/register_emp")
				public String showRegForm(Employee e)
				{
					//User u=new User();getters;setters
					//map.addAttribute("user",u);
					System.out.println("in show reg form "+e);
					return "admin/register_emp";
				}				
	//request handling method for processing reg form
				@PostMapping("/register_emp") //=@RequestMapping + method=post
				public String processRegForm(@Valid Employee e,BindingResult result,RedirectAttributes flashMap)
				{
					//User u=new User(); getters / matching setters /
					//map.addAttribute("user",u)
					System.out.println("in process reg form "+e);//u -- transient POJO
					//chk P.L errs
					if(result.hasErrors())
					{
						System.out.println("P.L errs");
						//forward the clnt to reg form highlighted with errs
						return "admin/register_emp";
					}
					flashMap.addFlashAttribute("status", service.registerEmployee(e));
					return "redirect:/admin/list_emp";
				}	
				
				
				
				
				//req handling method to delete customer dtls
				@GetMapping("/delete")
				public String deleteCustomer(RedirectAttributes flashMap,@RequestParam int id)
				{
					System.out.println("in delete customer "+id);
					flashMap.addFlashAttribute("status",service.deleteCustomer(id));
					return "redirect:/admin/list_cust";
				}
				
				
				
				//request handling method for showing vendor updation form
				@GetMapping("/update_cust")
				public String showUpdateFormForCust(@RequestParam int id,Model map)
				{
						System.out.println("in show update form "+id);
						map.addAttribute("Customer",service.getCustomerDetails(id));
						System.out.println(map);
						return "admin/update_cust";
				}
				//request handling method for processing vendor updation form
						@PostMapping("/update_cust")
						public String processUpdateForm(Customer c,RedirectAttributes attrs)
						{
								System.out.println("in process update form "+c);
								attrs.addFlashAttribute("status", service.updateCustomerDetails(c));
								return "redirect:/admin/list_cust";
						}				
				
						
						
						
						
						//request handling method for showing vendor updation form
						@GetMapping("/update_emp")
						public String showUpdateFormForEmp(@RequestParam int id,Model map)
						{
								System.out.println("in show update form "+id);
								map.addAttribute("Employee",service.getEmployeeDetails(id));
								System.out.println(map);
								return "admin/update_emp";
						}
						//request handling method for processing vendor updation form
								@PostMapping("/update_emp")
								public String processUpdateForm(Employee e,RedirectAttributes attrs)
								{
										System.out.println("in process update form "+e);
										attrs.addFlashAttribute("status", service.updateEmployeeDetails(e));
										return "redirect:/admin/list_emp";
								}	
				
				
				
}
