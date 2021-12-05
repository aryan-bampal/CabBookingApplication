package com.capg.cba.controllers;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.capg.cba.entities.Admin;
import com.capg.cba.entities.TripBooking;
import com.capg.cba.exception.AdminNotFoundException;
import com.capg.cba.services.IAdminService;
//import com.capg.cba.exception.CabNotFoundException;
//import com.capg.cba.exception.DriverNotFoundException;
import com.capg.cba.services.IAdminServiceI;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="admin")
@CrossOrigin("http://localhost:4200")
@Api(value="IAdminController")
public class IAdminController {
	
	@Autowired
	IAdminService iadminservicei;
	
	
	@PostMapping("/insert")
	public ResponseEntity<Boolean> insert(@RequestBody Admin pro) throws AdminNotFoundException
	{
		if(pro.getAdminId()==0)
			throw new AdminNotFoundException("Oops!!No admin found for given Id");
		iadminservicei.insertAdmin(pro);
		
      ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
	
	@PutMapping("/update")  //localhost:9090/product/update
	public ResponseEntity<Admin> updateProduct(@RequestBody Admin admin) throws AdminNotFoundException
	{
		admin=iadminservicei.updateAdmin(admin);
		if(admin.getAdminId()==0)
			throw new AdminNotFoundException("Oops!!No admin found for given Id");

		return new ResponseEntity<Admin>(admin,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{id}") //localhost:9090/delete/{empId}
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		iadminservicei.deleteAdmin(id);
		return new ResponseEntity<String>("Record TripBooking Deleted",HttpStatus.OK);
	}
	
	@GetMapping("/alltrips/{id}")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable int id) throws AdminNotFoundException
	{
		List<TripBooking> list=iadminservicei.getAllTrips(id);
		if(list.isEmpty())
		throw new AdminNotFoundException("Oops!!The List is Empty");
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/tripscabwise")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getTripsCabwise() throws AdminNotFoundException
	{
		List<TripBooking> list=iadminservicei.getTripsCabwise();
		if(list.isEmpty())
			throw new AdminNotFoundException("Oops!!The List is Empty");
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/tripscustomerwise")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getTripsCustomerwise() throws AdminNotFoundException
	{
		List<TripBooking> list=iadminservicei.getTripsCustomerwise();
		if(list.isEmpty())
			throw new AdminNotFoundException("Oops!!The List is Empty");
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/tripsdatewise")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getTripsDatewise() throws AdminNotFoundException
	{
		List<TripBooking> list=iadminservicei.getTripsDatewise();
		if(list.isEmpty())
			throw new AdminNotFoundException("Oops!!The List is Empty");
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	@GetMapping("/alltripscustomerwise/{id}/{fromdate}/{todate}")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getAllTripsForDays(@PathVariable int id,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromdate,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime todate)
	{
		List<TripBooking> list=iadminservicei.getAllTripsForDays(id,fromdate,todate);
				return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}	
}