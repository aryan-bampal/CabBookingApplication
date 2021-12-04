package com.capg.cba;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.cba.entities.Driver;
//import com.capg.cba.repository.CabRepository;
import com.capg.cba.repository.DriverRepository;
//import com.capg.cba.services.CabServicesImpl;
import com.capg.cba.services.DriverServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDriver {
	@InjectMocks
	private DriverServiceImpl service;
	@Mock
	private DriverRepository Dao;
	@Test
	public void updateDriver()
	{
	Driver driver =new Driver();
       driver.setDriverId(12);
	 driver.setLicenceNo("please reslove the issue");
		driver.setRating(4);
		Mockito.when(Dao.updateDriver(driver)).thenReturn(driver);
	}
//	@Test
//	public void insertDriver() {
//		Driver driver1 = new Driver();
//		driver1.setDriverId(1);
//		driver1.setLicenceNo("please reslove the issue");
//		driver1.setRating(43);
//		//	Mockito.when(Dao.insertDriver(driver)).thenReturn(driver);
//		Mockito.when(Dao.insertDriver(driver1)).thenReturn(driver1);
		}
	

