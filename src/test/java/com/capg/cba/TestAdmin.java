package com.capg.cba;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.cba.entities.Admin;
import com.capg.cba.entities.Driver;
import com.capg.cba.repository.DriverRepository;
import com.capg.cba.repository.IAdminRepository;
import com.capg.cba.services.DriverServiceImpl;
import com.capg.cba.services.IAdminServiceI;


	

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAdmin {
	@InjectMocks
	private IAdminServiceI service;
	@Mock
	private IAdminRepository Dao;
	@Test
	public void updateDriver()
	{
		Admin admin1 = new Admin();
		admin1.setAdminId(12);
		Mockito.when(Dao.updateAdmin(admin1)).thenReturn(admin1);
	}
	
	@Test
	public void deleteAdmin() {
		Admin admin1 = new Admin();
		admin1.setAdminId(12);
		Mockito.when(Dao.deleteAdmin(12)).thenReturn(admin1);
		}
	}
