package com.capg.cba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.cba.entities.Cab;
import com.capg.cba.repository.CabRepository;


@Service
//@Service annotation is used in your service layer and annotates classes that perform service tasks

public class CabServicesImpl implements CabService{
	
	@Autowired
	//Autowiring makes the container to search the bean configurations and do the collaboration among beans,

	private CabRepository dao;
	
	public Cab insertCab(Cab cab) {
		return dao.insertCab(cab);
	}
	
	public Cab findCabById(int cabId) {
		return dao.findCabById(cabId);
	}

	public Cab updateCab(Cab cab) {
		return dao.updateCab(cab);
	}
	
	public List<Cab> viewCabsOfType(String carType){
		 return dao.viewCabsOfType(carType);
	}
	public int countCabsOfType(String carType) {
		return dao.countCabsOfType(carType);
	}
	public Cab deleteCab(int cabId) {
		 return dao.deleteCab(cabId);
	}

}


