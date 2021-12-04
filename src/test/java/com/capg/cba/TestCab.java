package com.capg.cba;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.cba.entities.Cab;
import com.capg.cba.repository.CabRepository;
import com.capg.cba.services.CabServicesImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCab{
@InjectMocks
private CabServicesImpl service;

@Mock
private CabRepository Dao;
@Test
public void updateCabtest() {
	Cab cab1 = new Cab();
	
	cab1.setCabId(1);
	cab1.setCarType("pleas");
	cab1.setPerKmRate(66);
	
		Mockito.when(Dao.updateCab(cab1)).thenReturn(cab1);
}
@Test
public void deleteCabtest() {
	Cab cab1 = new Cab();
	
	cab1.setCabId(1);
	cab1.setCarType("pleas");
	cab1.setPerKmRate(66);
	
		Mockito.when(Dao.deleteCab(0)).thenReturn(cab1);
				
}
}