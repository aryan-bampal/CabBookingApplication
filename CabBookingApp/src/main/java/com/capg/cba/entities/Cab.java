package com.capg.cba.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cab")
public class Cab extends AuditModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1736893392612608637L;
	@Id
	@GeneratedValue
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
	Cab()
	{
		super();
	}
}
