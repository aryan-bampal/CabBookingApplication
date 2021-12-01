package com.capg.cba.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Driver")
public class Driver extends AbstractUser{
	@Id
	@GeneratedValue
	private int driverId;
	private String licenceNo;
	private float rating;
	private String username;
	private String password;
	private String address;
	private int mobileNumber;
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cab_id")
	private Cab cab;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="tripBookingId")
	private List<TripBooking> tripbooking;
	
	public String getLicenceNo() {
		return licenceNo;
	}
	public float getRating() {
		return rating;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public Cab getcab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public int getDriverId() {
		return driverId;
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
	
	Driver()
	{
		super();
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", rating=" + rating + ", username="
				+ username + ", password=" + password + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", cab=" + cab + ", tripbooking=" + tripbooking + "]";
	}
	
	
}
