package com.capg.cba.entities;

abstract class AbstractUser {
	abstract public String getUsername();
	abstract public String getPassword();
	abstract public String getAddress();
	abstract public int getMobileNumber();
	abstract public String getEmail();
	abstract public void setUsername(String username);
	abstract public void setPassword(String password);
	abstract public void setAddress(String address);
	abstract public void setEmail(String email);
	abstract public void setMobileNumber(int mobileNumber);
	abstract public void setCustomerId(int customerId); {
		// TODO Auto-generated method stub
		
	}
	public int getCustomerId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
