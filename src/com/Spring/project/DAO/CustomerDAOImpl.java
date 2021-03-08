package com.Spring.project.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.project.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customer = query.getResultList();
		return customer;
	}

	@Override
	public void addCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
	}

	@Transactional
	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theId);
		return customer;
	}
	
	@Transactional
	@Override
	public Customer deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer customer  = session.get(Customer.class, theId);
		System.out.println("Deleting customer in DAO");
		session.delete(customer);
		System.out.println("Customer deleted from dao");
		return customer ;
	}

	@Transactional
	@Override
	public List<Customer> getCustomer(String firstName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer where first_name = :firstName", Customer.class);
		query.setParameter("firstName", firstName);
		List <Customer> customer = query.getResultList();
		return customer;
	}



	
}
