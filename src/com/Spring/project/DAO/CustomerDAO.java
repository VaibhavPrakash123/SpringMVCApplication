package com.Spring.project.DAO;

import java.util.List;

import com.Spring.project.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();
	public void addCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public Customer deleteCustomer(int theId);
	public List<Customer> getCustomer(String firstName);
	
}
