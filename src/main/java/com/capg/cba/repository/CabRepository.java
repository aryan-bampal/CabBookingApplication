package com.capg.cba.repository;

import java.util.List;

import com.capg.cba.entities.Cab;

public interface CabRepository {
	Cab insertCab(Cab cab);
	Cab findCabById(int cabId);
    Cab updateCab(Cab cab); 
	List<Cab> viewCabsOfType(String carType);
	Cab deleteCab(int cabId);
	int countCabsOfType(String CarType);
	
}
