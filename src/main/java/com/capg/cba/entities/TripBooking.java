package com.capg.cba.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TripBooking")
public class TripBooking {
	@Id
	@GeneratedValue
	private int tripBookingId;
	private int customerId;
	private int driverId;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromLocalDateTime;
	private LocalDateTime toLocalDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
	
	@ManyToOne
	@JoinColumn(name="Driver")
	private Driver driver;
	
	public Driver getDriver() {
		return driver;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@ManyToOne
	@JoinColumn(name="Customer")
	private Customer customer;
	
	public int getTripBookingId() {
		return tripBookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public int getDriverId() {
		return driverId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public LocalDateTime getFromLocalDateTime() {
		return fromLocalDateTime;
	}
	public LocalDateTime getToLocalDateTime() {
		return toLocalDateTime;
	}
	public boolean getStatus() {
		return status;
	}
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill=bill;
	}
	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public void setFromLocalDateTime(LocalDateTime fromLocalDateTime) {
		this.fromLocalDateTime = fromLocalDateTime;
	}
	public void setToLocalDateTime(LocalDateTime toLocalDateTime) {
		this.toLocalDateTime = toLocalDateTime;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
		
	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", customerId=" + customerId + ", driverId=" + driverId
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromLocalDateTime="
				+ fromLocalDateTime + ", toLocalDateTime=" + toLocalDateTime + ", status=" + status + ", distanceInKm="
				+ distanceInKm + ", bill=" + bill + "]";
	}
	
}
