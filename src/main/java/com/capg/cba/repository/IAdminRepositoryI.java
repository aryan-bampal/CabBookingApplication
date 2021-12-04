package com.capg.cba.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.capg.cba.entities.Admin;
import com.capg.cba.entities.TripBooking;

public interface IAdminRepositoryI {
	public void insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId);
	public List<TripBooking> getAllTrips(int customerId);
	public List<TripBooking> getTripsCabwise();
	public List<TripBooking> getTripsCustomerwise();
	public List<TripBooking> getTripsDatewise();
	public List<TripBooking> getAllTripsForDays(int customerid,LocalDateTime fromdate,LocalDateTime todate );
}
