package com.spring.rest.crud.dao;

import java.util.List;

import com.spring.rest.crud.model.Customer;

public interface CustomerDAO 
{
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int id);

}
