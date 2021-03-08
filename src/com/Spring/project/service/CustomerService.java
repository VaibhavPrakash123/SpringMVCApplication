package com.Spring.project.service;

import java.util.List;

import com.Spring.project.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomer();
	public void addCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public String deleteCustomer(int theId);
	public List<Customer> getCustomer(String firstName);

}
