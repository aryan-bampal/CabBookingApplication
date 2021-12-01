package com.capg.cba.entities;

public class Admin extends AbstractUser{

	
	private int adminId;
	private String username;
	private String password;
	private String address;
	private int mobileNumber;
	private String email;
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public int getMobileNumber() {
		// TODO Auto-generated method stub
		return mobileNumber;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username=username;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address=address;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email=email;
	}
	@Override
	public void setMobileNumber(int mobileNumber) {
		// TODO Auto-generated method stub
		this.mobileNumber=mobileNumber;
	}
	
	Admin()
	{
		super();
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", address="
				+ address + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	
	
}
