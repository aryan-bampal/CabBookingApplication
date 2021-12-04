package com.capg.cba.services;

import java.util.List;
import com.capg.cba.entities.Cab;

public interface CabService {

	     Cab insertCab(Cab cab);
	     
	     Cab findCabById(int cabId);
	     
	    Cab updateCab(Cab cab);
	    		
		List<Cab> viewCabsOfType(String CarType);
		
		int countCabsOfType(String carType);
		
		Cab deleteCab(int cabId); 

	}

