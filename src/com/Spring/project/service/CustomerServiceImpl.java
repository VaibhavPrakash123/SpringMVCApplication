package com.Spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.project.DAO.CustomerDAO;
import com.Spring.project.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
	
		return customerDAO.getCustomer();
	}

	@Transactional
	@Override
	public void addCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDAO.addCustomer(theCustomer);
		System.out.println("The Customer is saved");
		
	}

	@Transactional
	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Customer customer = customerDAO.getCustomer(theId);
		return customer;
	}

	@Transactional
	@Override
	public String deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		
		customerDAO.deleteCustomer(theId);
		System.out.println("Customer deleted");
		return null;
	}

	@Transactional
	@Override
	public List<Customer> getCustomer(String firstName) {
		
		List<Customer>customer = customerDAO.getCustomer(firstName);
		return customer;
	}



}
