package com.capg.cba;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.cba.entities.Customer;
import com.capg.cba.repository.ICustomerRepository;
import com.capg.cba.services.ICustomerServiceImpl;
//import com.cg.hims.entities.Agent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomer {
@InjectMocks
private ICustomerServiceImpl service;

@Mock
private ICustomerRepository Dao;
@Test
public void insertCustomerTest1() {
 Customer customer1 = new Customer();
 
 customer1.setCustomerId(8);
 customer1.setUsername("anvey");
 customer1.setMobileNumber(2345667);
 customer1.setPassword("57");
 customer1.setEmail("anvey@gmail.com");
 customer1.setAddress("16");
	
	
		Mockito.when(Dao.insertCustomer(customer1)).thenReturn(customer1);
}
@Test
public void deleteCustomerTest1() {
 Customer customer1 = new Customer();
 
 customer1.setCustomerId(8);
 customer1.setUsername("anvey");
 customer1.setMobileNumber(2345667);
 customer1.setPassword("57");
 customer1.setEmail("anvey@gmail.com");
 customer1.setAddress("16");
	
	
		Mockito.when(Dao.deleteCustomer(0)).thenReturn(customer1);
	
}
}


