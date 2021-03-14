package com.Spring.project.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring.project.entity.Customer;
import com.Spring.project.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	
	


	public CustomerService getCustomerService() {
		return customerService;
	}





	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}





	@RequestMapping("/list")
	public String CustomerList(Model theModel)
	{
		List<Customer> customer = customerService.getCustomer();
		
		theModel.addAttribute("customers",customer);
		return "customer-list";
	}
	@RequestMapping("/showFormForAdd")
	public String showFormToAdd(Model theModel)
	{
		Customer customer  = new Customer();
		theModel.addAttribute(customer);
		return "add-customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@Valid@ModelAttribute("customer") Customer theCustomer)
	{
		customerService.addCustomer(theCustomer);
		return "redirect:list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormUpdate(@RequestParam("customerId") int theId, Model theModel)
	{
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute(theCustomer);
		System.out.println("Into Update form");
		return "add-customer-form";
	}
	
	@GetMapping("/showFormForDelete")
	public String deleteCustomer(@RequestParam("customerId")int theId, Model theModel)
	{
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	//Search Customer
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("searchName") String firstName, Model theModel)
	{
		List<Customer> customer = customerService.getCustomer(firstName);
		theModel.addAttribute("customers",customer);
		System.out.println(customer);
		return "customer-list";
	
	}
	
}
