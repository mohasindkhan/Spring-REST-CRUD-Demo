package com.spring.rest.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.crud.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Customer> getCustomers() 
	{
		Customer cust = new Customer();
		
		System.out.println(" ------------------------------------------------------------------------------------------------- ");
		
		System.out.println(" \n GETTING CUSTOMER DEATILS : " + cust);
		
		System.out.println(" ------------------------------------------------------------------------------------------------- ");
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		
		List<Customer> list = query.getResultList();
		
		return list;
	}
	
	
	@Override
	public Customer getCustomer(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}


	@Override
	public void saveCustomer(Customer customer) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}


	@Override
	public void deleteCustomer(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id = :customerId");
		
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}


}
