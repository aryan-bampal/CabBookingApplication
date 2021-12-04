package com.capg.cba.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.corejava.Repository.ICustomerRepository;
//import com.corejava.entity.Customer;

import com.capg.cba.entities.Customer;
import com.capg.cba.repository.ICustomerRepository;

  /*Annotate all our service classes with  @Service .all our business logic should be in Service classes*/

   @Service
   public class ICustomerServiceImpl implements ICustomerService 
  {
   /*Spring auto wire other beans into your classes using@Autowired annotation*/
	
   @Autowired

   ICustomerRepository dao;

   public Customer insertCustomer(Customer customer) {
   return dao.insertCustomer(customer);
   }
   public Customer updateCustomer(Customer customer)
   {
   return dao.updateCustomer(customer);
   }
   public Customer deleteCustomer(int customerId) {
   return dao.deleteCustomer(customerId);
   }
   public List<Customer> viewCustomers(){
   return dao.viewCustomers();
   }
   public Customer viewCustomer(int customerId) {
   return dao.viewCustomer(customerId);
   }
   public Customer validateCustomer(String username,String password)
   {
   return dao.validateCustomer(username,password);
   }
    }