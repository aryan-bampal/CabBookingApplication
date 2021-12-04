package com.capg.cba.repository;

import java.util.List;

import com.capg.cba.entities.Customer;

//import com.corejava.entity.Customer;


    public interface ICustomerRepository {
	
	Customer insertCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	Customer deleteCustomer(int customerId);
	
	List<Customer> viewCustomers();
	
	Customer viewCustomer(int customerId);	
	
	Customer validateCustomer(String username,String password);

	// deleteCustomer(int customerId);

	//void updateCustomer(Customer customer);

	//Customer deleteCustomer(int customerId);

	
	
}




