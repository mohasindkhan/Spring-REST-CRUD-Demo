package com.spring.rest.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.crud.exception.UserException;
import com.spring.rest.crud.model.Customer;
import com.spring.rest.crud.service.CustomerService;

@RestController
@RequestMapping("/api")
public class SpringRestController 
{
	
	
	@Autowired
	private CustomerService customerService;
	
	
	// GET ALL CUSTOMERS FOR REST
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	
	// GET SINGLE CUSTOMER BY ID
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id)
	{
		Customer customer = customerService.getCustomer(id);
		
		if(customer == null)
		{
			throw new UserException(" Customer ID Not Found : " +id);
		}
		
		return customer;
		
	}
	
	
	// INSERT NEW CUSTOMER
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		customer.setId(0);
		
		customerService.saveNewCustomer(customer);
		
		return customer;
	}
	
	
	// UPDATE CUSTOMER
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		customerService.saveNewCustomer(customer);
		return customer;
	}
	
	
	// DELETE CUSTOMER
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		Customer customer = customerService.getCustomer(id);
		
		if(customer == null)
		{
			throw new UserException(" Customer ID Not Found : " +id);
		}
		
		customerService.deleteCustomer(id);
		
		return "Deleted Customer With ID : " +id;
	}

}
