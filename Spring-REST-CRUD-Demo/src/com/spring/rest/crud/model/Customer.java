package com.spring.rest.crud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESTCustomer")
public class Customer 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="EmailID")
	private String emailId;
	
	@Column(name="CustomerDate")
	private Date customerDate;
	

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEmailId() 
	{
		return emailId;
	}

	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}

	public Date getCustomerDate() 
	{
		return customerDate;
	}

	public void setCustomerDate(Date customerDate) 
	{
		this.customerDate = customerDate;
	}
	

	@Override
	public String toString() 
	{
		return " Customer [ ID = " + id + " , First-Name = " + firstName + " , Last-Name = " + lastName + " , Email-Id = " + emailId + " , Date = " + customerDate + " ] ";
	}
	
	
}
