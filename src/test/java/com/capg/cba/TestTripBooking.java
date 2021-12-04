package com.capg.cba;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.cba.entities.Cab;
import com.capg.cba.entities.TripBooking;
import com.capg.cba.repository.CabRepository;
import com.capg.cba.repository.ITripBookingRepository;
import com.capg.cba.services.CabServicesImpl;
import com.capg.cba.services.ITripBookingService;
import com.capg.cba.services.ITripBookingServiceI;


	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class TestTripBooking{
	@InjectMocks
	private ITripBookingService service;

	@Mock
	private ITripBookingRepository Dao;
	@Test
	public void insertTripbooking() {
		TripBooking tripbooking= new TripBooking();
		
		tripbooking.setTripBookingId(1);      
		tripbooking.setBill(8);           
		tripbooking.setCustomerId(2);     
		tripbooking.setDistanceInKm(6878);    
		tripbooking.setDriverId(7);    
		//tripbooking.setToLocalDateTime(2/12/2007 13:09:42.87); 
		tripbooking.setFromLocation("pdpl");     
		tripbooking.setStatus(true);    
		//tripbooking.setFromLocalDateTime(76/98);  
		tripbooking.setToLocation("uhyg");   
			}
	@Test
	public void updateTripBooking() {
		TripBooking tp=new TripBooking();
		tp.setTripBookingId(12);
		tp.setFromLocation("n");
		tp.setToLocation("dfrg");
		tp.setDistanceInKm(65);
		tp.setBill(6);
Mockito.when(Dao.updateTripBooking(tp)).thenReturn(tp);
					
}
}