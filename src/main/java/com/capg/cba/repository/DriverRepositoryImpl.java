package com.capg.cba.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.capg.cba.entities.Driver;

	@Repository
	@Transactional

public  class DriverRepositoryImpl implements DriverRepository
	 {
		@PersistenceContext
	    private EntityManager entityManager;
		

		 @Override
		public Driver insertDriver(Driver driver) {
			 
		return entityManager.merge(driver);
	 }
		 
			//@Override
			//public Driver findDriverById(int driverId) {
				//return entityManager.find(Driver.class,driverId);
			//}

			
		 @Override
		public Driver updateDriver(Driver driver) {
			 return entityManager.merge(driver);
								
    }
						
		 @Override
		public Driver deleteDriver(int driverId) {
		Driver driver=entityManager.find(Driver.class, driverId);
     	entityManager.remove(driverId);
     	return driver;
	}
						
		 @Override
		public Driver viewDriver(int driverId) {
		Driver driver=entityManager.find(Driver.class,driverId);  	
      return driver;
		 }
		 
		 
		@Override
			public List<Driver> viewBestDrivers() {
				// TODO Auto-generated method stub
				Query q = entityManager.createQuery("select e from Driver e where e.rating>4.5");
			    List<Driver> list=q.getResultList();
				return list;
			}
	 }

