package com.capg.cba.repository;

import java.util.List;

import com.capg.cba.entities.Cab;
import com.capg.cba.entities.Driver;

public interface DriverRepository {
	
 Driver insertDriver(Driver driver);
 Driver updateDriver(Driver driver);
 //Driver findDriverById(int driverId);
 Driver deleteDriver(int driverId);
 List<Driver> viewBestDrivers();
 Driver viewDriver(int driverId);

}
