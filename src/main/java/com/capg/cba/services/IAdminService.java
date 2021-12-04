package com.capg.cba.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.cba.entities.Admin;
import com.capg.cba.entities.TripBooking;
import com.capg.cba.repository.IAdminRepositoryI;

@Service
public class IAdminService implements IAdminServiceI{

	@Autowired
	IAdminRepositoryI iadminrepositoryi;
	

	@Override
	public void insertAdmin(Admin admin) {
		iadminrepositoryi.insertAdmin(admin);
		
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return iadminrepositoryi.updateAdmin(admin);
	}

	@Override
	public Admin deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		return iadminrepositoryi.deleteAdmin(adminId);
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		// TODO Auto-generated method stub
		return iadminrepositoryi.getAllTrips(customerId);
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		// TODO Auto-generated method stub
		return iadminrepositoryi.getTripsCabwise();
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		// TODO Auto-generated method stub
		return iadminrepositoryi.getTripsCustomerwise();
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		// TODO Auto-generated method stub
		return iadminrepositoryi.getTripsDatewise();
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerid, LocalDateTime fromdate, LocalDateTime todate) {
		// TODO Auto-generated method stub
		return iadminrepositoryi.getAllTripsForDays(customerid, fromdate, todate);
	}
	
}
