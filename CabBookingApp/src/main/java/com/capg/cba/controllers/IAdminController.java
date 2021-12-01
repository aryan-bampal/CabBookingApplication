package com.capg.cba.controllers;

import java.time.LocalDateTime;
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

import com.capg.cba.entities.Admin;
import com.capg.cba.entities.TripBooking;
import com.capg.cba.services.IAdminServiceI;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="admin")
@CrossOrigin("http://localhost:4200")
@Api(value="IAdminController")
public class IAdminController {
	
	@Autowired
	IAdminServiceI iadminservicei;
	
	
	@PostMapping("/insert")
	public ResponseEntity<Boolean> insert(@RequestBody Admin pro)
	{
		iadminservicei.insertAdmin(pro);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
	
	@PutMapping("/update")  //localhost:9090/product/update
	public ResponseEntity<Admin> updateProduct(@RequestBody Admin admin)
	{
		admin=iadminservicei.updateAdmin(admin);
		return new ResponseEntity<Admin>(admin,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{id}") //localhost:9090/delete/{empId}
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		iadminservicei.deleteAdmin(id);
		return new ResponseEntity<String>("Record TripBooking Deleted",HttpStatus.OK);
	}
	
	@GetMapping("/alltrips/{id}")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable int id)
	{
		List<TripBooking> list=iadminservicei.getAllTrips(id);
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/alltripscabwise")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getTripsCabwise()
	{
		List<TripBooking> list=iadminservicei.getTripsCabwise();
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/alltripscustomerwise")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getTripsCustomerwise()
	{
		List<TripBooking> list=iadminservicei.getTripsCustomerwise();
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/alltripsdatewise")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getTripsDatewise()
	{
		List<TripBooking> list=iadminservicei.getTripsDatewise();
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	@GetMapping("/alltripscustomerwise/{id}/{fromdate}/{todate}")  //localhost:9090/product/getall
	public ResponseEntity<List<TripBooking>> getAllTripsForDays(@PathVariable int id,@PathVariable LocalDateTime fromDate,@PathVariable LocalDateTime toDate)
	{
		List<TripBooking> list=iadminservicei.getAllTripsForDays(id,fromDate,toDate);
		return new ResponseEntity<List<TripBooking>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	
	
	
}
