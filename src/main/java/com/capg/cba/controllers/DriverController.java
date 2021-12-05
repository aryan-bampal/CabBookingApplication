package com.capg.cba.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.capg.cba.entities.Driver;
import com.capg.cba.repository.DriverNotFoundException;
import com.capg.cba.services.DriverService;

import io.swagger.annotations.Api;

@RestController
//accepts request from outside sources like webbrowser
//controller+HTTP protocals
@RequestMapping(value="driver")
/*The @RequestMapping annotation ensures that HTTP requests to /Product are mapped to the Product() method or Product class.
It is used to map web requests onto specific handler classes and/or handler methods*/
@CrossOrigin("http://localhost:4200")
//@CrossOrigin annotation enables cross-origin resource sharing only for this specific method.
@Api(value="DriverController")

 public class DriverController {
	@Autowired
	//Autowiring makes the container to search the bean configurations and do the collaboration among beans,
    private DriverService service;
	
	/*The @PostMapping annotated methods in the @Controller annotated classes handle the HTTP POST
	requests matched with given URI expression.*/

	@PostMapping(path="/insert")
	public ResponseEntity<Object> insertDriver(@RequestBody Driver driver) throws DriverNotFoundException
	{
		Driver driver1=service.insertDriver(driver);
		if(driver.getDriverId()==0)
			throw new DriverNotFoundException("Oops!!No Driver found for given Id");
		ResponseEntity<Object> responseEntity = new ResponseEntity(driver1, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
/*	The @GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET 
 * requests matched with given URI expression.
 */
	@GetMapping(path="/viewDriver/{driverId}")
 	public ResponseEntity<Driver> viewDriver(@PathVariable int driverId)
	{
	Driver driver=service.viewDriver(driverId);
		if(driver==null)
	{
			throw new DriverNotFoundException("Driver not found for id=" + driverId);
		}
		
		return new ResponseEntity<Driver>(driver,new HttpHeaders(),HttpStatus.OK);
	}
//mapping HTTP PUT requests onto specific handler methods.

	@PutMapping(path="/update")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) throws DriverNotFoundException
	{
	    driver=service.updateDriver(driver);
        if((driver.getDriverId()==0)||(driver.getLicenceNo()==null)||(driver.getRating()==0||(driver.getLicenceNo().length()==0)))
			throw new DriverNotFoundException("enter the Driver Details to be updated");
		
	    return new ResponseEntity<Driver>(driver,new HttpHeaders(),HttpStatus.OK);
	}
     @GetMapping(path="/getbestdrivers")
	public  ResponseEntity<List<Driver>> viewBestDrivers() throws DriverNotFoundException
     {
		List<Driver> list=service.viewBestDrivers();
		if(list.isEmpty())
	 		throw new DriverNotFoundException("Oops!!The List is Empty");

		return new ResponseEntity<List<Driver>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	@DeleteMapping(path="/delete/{driverId}")
	public String deleteDriver(@PathVariable int driverId) {
		service.deleteDriver(driverId);
		return "Deleted";
	}
}


