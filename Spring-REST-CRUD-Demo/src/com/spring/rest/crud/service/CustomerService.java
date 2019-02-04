package com.spring.rest.crud.service;

import java.util.List;

import com.spring.rest.crud.model.Customer;

public interface CustomerService 
{
		
	public List<Customer> getAllCustomers();
	
	public Customer getCustomer(int id);
	
	public void saveNewCustomer(Customer customer);
	
	public void deleteCustomer(int id);

}
