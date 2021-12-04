package com.capg.cba.services;

import java.util.List;
import com.capg.cba.entities.Driver;

public interface DriverService {

	     Driver insertDriver(Driver driver);
	     
        Driver viewDriver(int driverId);
	     
       // Driver findDriverById(int driverId);
        
	     Driver updateDriver(Driver driver);
	    		
		List<Driver> viewBestDrivers();
		
			Driver deleteDriver(int driverId);



	}