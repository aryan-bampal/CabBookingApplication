package com.capg.cba.services;

import java.util.List;

import com.capg.cba.entities.Customer;


    public interface ICustomerService {
	
    Customer insertCustomer(Customer customer); 	
	 
	Customer updateCustomer(Customer customer);
	 
	Customer deleteCustomer(int customerId);
	 
	List<Customer> viewCustomers();
	Customer viewCustomer(int customerId);
	
	Customer validateCustomer(String username,String password);

	//void deleteCustomer(int customerId);

	

}		