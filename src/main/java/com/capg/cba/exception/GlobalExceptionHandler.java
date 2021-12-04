package com.capg.cba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;



public class GlobalExceptionHandler {
	//Exception for Cab
		@ExceptionHandler(value=CabNotFoundException.class)
		public ResponseEntity<Object> CanException(CabNotFoundException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		//Exception for Driver
		@ExceptionHandler(value=DriverNotFoundException.class)
		public ResponseEntity<Object> DriverException(DriverNotFoundException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		//Exception for IAdmin
		@ExceptionHandler(value=AdminNotFoundException.class)
		public ResponseEntity<Object> AdminException(AdminNotFoundException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		//Exception for ITripBooking
		@ExceptionHandler(value=TripBookingNotFoundException.class)
		public ResponseEntity<Object> TripBoookingException(TripBookingNotFoundException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		//Exception for Customer
				@ExceptionHandler(value=CustomerNotFoundException.class)
				public ResponseEntity<Object> CustomerException(CustomerNotFoundException e){
					return new ResponseEntity<>("Customer not found",HttpStatus.NOT_FOUND);
				}
		
}
