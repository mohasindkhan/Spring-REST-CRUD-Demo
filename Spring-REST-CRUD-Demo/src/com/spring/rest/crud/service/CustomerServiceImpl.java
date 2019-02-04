package com.spring.rest.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.crud.dao.CustomerDAO;
import com.spring.rest.crud.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	
	
	@Autowired
	private CustomerDAO customerdao;

	
	@Override
	@Transactional(readOnly = false)
	public List<Customer> getAllCustomers() 
	{
		return customerdao.getCustomers();
	}
	
	
	@Override
	@Transactional(readOnly = false)
	public Customer getCustomer(int id) 
	{
		return customerdao.getCustomer(id);
	}


	@Override
	@Transactional(readOnly = false)
	public void saveNewCustomer(Customer customer) 
	{
		customerdao.saveCustomer(customer);
	}


	@Override
	@Transactional(readOnly = false)
	public void deleteCustomer(int id) 
	{
		customerdao.deleteCustomer(id);
	}


}
