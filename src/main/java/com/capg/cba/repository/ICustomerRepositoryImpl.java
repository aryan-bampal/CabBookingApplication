package com.capg.cba.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.cba.entities.Customer;

//import com.corejava.entity.Customer;

       /*Annotate all our DAO classes with @Repository.all our database access logic should be in Repository 
        classes.*/
	   @Repository
	   /*configure our transactions with @Transactional spring annotation*/
	   @Transactional
        public  class ICustomerRepositoryImpl implements ICustomerRepository
	    { 
	    /*Expresses a dependency on a  container managed  EntityManager
	 
	  Within the persistence context, the entity instances and their lifecycle are managed.
	   The EntityManager API is used to create and remove persistent entity instances, to find
	   entities by their primary key, and to query over entities*/
	   @PersistenceContext
	   /*This EntityManager manages entities (customer bean is defined as an entity)*/
	   private EntityManager entityManager;
		
	  /*@Override annotation assures that the subclass method is overriding the parent class method*/
	   @Override
	   public Customer insertCustomer(Customer customer) {
	   return entityManager.merge(customer);
	    }
	   @Override
	   public Customer updateCustomer(Customer customer) {

	   return entityManager.merge(customer);
			
	    }
		
		
		@Override
	    public Customer deleteCustomer(int customerId) {
		Customer customer=entityManager.find(Customer.class, customerId);
	    entityManager.remove(customer);
		return customer                  ;

		}
		@Override
		public List<Customer> viewCustomers()
		{
			Query q = entityManager.createQuery("select e from Customer  e");
		    List <Customer>list = q.getResultList();
		
			return list;
		}
		@Override
		public Customer viewCustomer(int customerId) {
			Customer customer=entityManager.find(Customer.class,customerId);  
          return customer;
		}
		@Override
		public Customer validateCustomer(String username,String password) {
		
		Query q = entityManager.createQuery("select e from Customer e where e.username=:customerId");
	     q.setParameter("customerId",username);
	     Customer customer=(Customer) q.getSingleResult();
		 System.out.println(customer.toString());
		if(customer!=null)
		{
		if(password==customer.getPassword())
		{
		return customer;
		}
				
		}
		return null;
		}
		}
	
	
	
	
	