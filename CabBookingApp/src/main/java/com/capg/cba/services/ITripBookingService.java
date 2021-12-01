package com.capg.cba.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.cba.entities.TripBooking;
import com.capg.cba.repository.ITripBookingRepositoryI;

@Service
public class ITripBookingService implements ITripBookingServiceI {
	
	@Autowired
	ITripBookingRepositoryI itripbookingrepositoryi;

	@Override
	public void insertTripBooking(TripBooking pro) {
		// TODO Auto-generated method stub
		itripbookingrepositoryi.insertTripBooking(pro);
		return ;
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(int id) {
		// TODO Auto-generated method stub
		return itripbookingrepositoryi.ViewAllTripsCustomer(id);
	}

	@Override
	public TripBooking updateTripBooking(TripBooking booking) {
		// TODO Auto-generated method stub
		return itripbookingrepositoryi.updateTripBooking(booking);
	}

	@Override
	public String deleteTripBooking(int id) {
		// TODO Auto-generated method stub
		return itripbookingrepositoryi.deleteTripBooking(id);
	}

	@Override
	public float calculateBill(int id) {
		// TODO Auto-generated method stub
		return itripbookingrepositoryi.calculateBill(id);
	}
	
	
	
	
	
	
	
}
