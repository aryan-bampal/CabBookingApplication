package com.capg.cba.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.cba.entities.Admin;
import com.capg.cba.entities.TripBooking;

@Repository
@Transactional
public class IAdminRepository implements IAdminRepositoryI{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		entityManager.merge(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		entityManager.merge(admin);
		return admin;
	}

	@Override
	public Admin deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		Admin emp=entityManager.find(Admin.class, adminId);
		entityManager.remove(emp);
		return emp;
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select e from TripBooking e where e.customerId = :customerId");
		query.setParameter("customerId", customerId);
		List<TripBooking> q=query.getResultList();
		return q;
		
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select e from TripBooking e order by driverId");
		List<TripBooking> q=query.getResultList();
		return q;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select e from TripBooking e order by customerId");
		List<TripBooking> q=query.getResultList();
		return q;
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select e from TripBooking e order by fromLocalDateTime");
		List<TripBooking> q=query.getResultList();
		return q;
	}
//select m from PartnerData m where eventTimestamp >= :fromDatetime and eventTimestamp < :toDatetime"
	@Override
	public List<TripBooking> getAllTripsForDays(int customerid, LocalDateTime fromdate, LocalDateTime todate) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select e from TripBooking e where e.fromLocalDateTime >= :fromDatetime and e.toLocalDateTime <= :toDatetime");
		query.setParameter("fromDatetime", fromdate);
		query.setParameter("toDatetime", todate);
		List<TripBooking> q=query.getResultList();
		return q;
	}
	
}
