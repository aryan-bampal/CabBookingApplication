package com.capg.cba.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cab")
public class Cab {
	/**
	 * 
	 */

	@Id
	private int cabId;
	private String carType;
	private float perKmRate;
	
	@OneToOne(mappedBy="cab")
	private Driver driver;
	
	public int getCabId() {
		return cabId;
	}
	public String getCarType() {
		return carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}
	
}
