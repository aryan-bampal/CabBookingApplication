package com.capg.cba.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.cba.entities.TripBooking;


@Repository
@Transactional
public class ITripBookingRepository implements ITripBookingRepositoryI{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertTripBooking(TripBooking pro) {
		// TODO Auto-generated method stub
		entityManager.merge(pro);
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(int id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select e from TripBooking e where e.customerId = :customerId");
		query.setParameter("customerId", id);
		List<TripBooking> q=query.getResultList();
		return q;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking booking) {
		// TODO Auto-generated method stub
//		TripBooking book=entityManager.find(TripBooking.class,booking.getTripBookingId());
//		book.setBill(booking.getBill());
//		book.setDistanceInKm(booking.getDistanceInKm());
//		book.setDriverId(booking.getDriverId());
//		book.setFromLocalDateTime(booking.getFromLocalDateTime());
//		book.setFromLocation(booking.getFromLocation());
//		book.setStatus(booking.getStatus());
//		book.setToLocalDateTime(booking.getToLocalDateTime());
//		book.setToLocation(booking.getToLocation());
//		book.setCustomerId(booking.getCustomerId());
		entityManager.merge(booking);
		return booking;
	}

	@Override
	public String deleteTripBooking(int id) {
		// TODO Auto-generated method stub
		TripBooking emp=entityManager.find(TripBooking.class, id);
		entityManager.remove(emp);
		
		return "Deleted";
	}

	@Override
	public float calculateBill(int id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select sum(e.bill) from TripBooking e where e.customerId = :customerId");
		query.setParameter("customerId", id);
		System.out.println();
		try 
		{
		Object a=query.getSingleResult();
		a.toString();
		float f=Float.parseFloat(a.toString());
		return f;
	     }
		catch(Exception e)
		{
			System.out.println(e);
		}
		return (float)0.0;
	}
	
}
