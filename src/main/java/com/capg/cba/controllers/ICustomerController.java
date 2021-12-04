package com.capg.cba.controllers;

    //import java.net.http.HttpHeaders;
   import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.cba.entities.Cab;
import com.capg.cba.entities.Customer;
import com.capg.cba.exception.CabNotFoundException;
import com.capg.cba.repository.CustomerNotFoundException;
import com.capg.cba.services.ICustomerService;

import io.swagger.annotations.Api;

    /*accept request from outside source like web browser*/

    @RestController

    /*mapping the web request onto the method and it can handle our requests.
      customer are mapped to the customer() methods*/

    @RequestMapping("/customer")

    /*@CrossOrigin annotation allows all origins,all headers and HTTP methods specified in the @Request mapping annotation*/

    @CrossOrigin("http://localhost:4200")
    @Api(value="ICustomerController")
    public class ICustomerController {
	
	/*This annotation is used to auto-wire spring bean on setter methods,constructor and instance variable.
	internally create a object.*/
	
	@Autowired
    ICustomerService service;
	
	/* @Postmapping can maps HTTP POST.mapped to insert
	 *@Request body method parameter is bounded to the body of the web request
	 *Customer should bind to the insert request
	 *ResponseEntity is an extension of HTTPEntity which has parameters
	 *@RequestBody method parameter is bounded to the body of the web request*/
	
	@PostMapping (path="/insert")
	
	public  ResponseEntity<Boolean> insertCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
    customer=service.insertCustomer(customer);
    if(customer.getCustomerId()==0)
		throw new CustomerNotFoundException("Oops!!No customer found for given Id");
    ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
	System.out.println("response entity=" + responseEntity);
	return responseEntity;
  } 
	
    /*Annotation for mapping HTTP PUT request onto updateCustomer(method)
	*@RequestBody annotation is used to indicating Customer should be bind to the update request*/
	
	@PutMapping(path="/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
	customer=service.updateCustomer(customer);
	if((customer.getCustomerId()==0)||(customer.getUsername()==null)||(customer.getMobileNumber()==0)||(customer.getEmail()==null)||(customer.getPassword()==null)||(customer.getAddress()==null))
	return new ResponseEntity("enter the Driver Details to be updated",HttpStatus.NOT_FOUND);   

	return new ResponseEntity<Customer>(customer,HttpStatus.OK);
  }
	
	/*DeleteMapping annotation mapping HTTP delete requests onto deleteCustomer(method).*/
	
	@DeleteMapping(path="/delete/{customerId}")
	
	/*@path variable methods parameter should be bound to URI a template variable 
	request path deleteCustomer will bind variable customer id*/ 
	public String deleteCustomer(@PathVariable("customerId") int customerId) {
	service.deleteCustomer (customerId);
	return "Deleted";
    }
	/*This annotation for HTTP get requests onto the(viewCustomers) methods.*/
	@GetMapping(path="/getAll")
	public  ResponseEntity<List<Customer>> getAll() throws CabNotFoundException{
	List<Customer> list=service.viewCustomers();
	if(list.isEmpty())
		throw new CabNotFoundException("Oops!!The List is Empty");

	return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
    }
	//mapping HTTP GET
	@GetMapping(path="/viewCustomer/{customerId}")
	
	/*The viewCustomer will bind variable customer id*/
    public  ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") int customerId){
    Customer customer=service.viewCustomer(customerId);
    if(customer == null) {
    throw new CustomerNotFoundException("Customer not found for id="+customerId);
    }
    return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	/*mapping HTTP validation onto the validateCustomer method*/
    @GetMapping(path= "/validateCustomer/{username}/{password}")
	/*The validateCustomer will bind variables username ,password*/
	
    public ResponseEntity<Customer> validateCustomer(@PathVariable String username ,@PathVariable String password) 
	{
		Customer customer=service.validateCustomer(username,password);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);	
     	}
	
     }