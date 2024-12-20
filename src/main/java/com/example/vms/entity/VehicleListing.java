package com.example.vms.entity;

import com.example.vms.enums.SeatingType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class VehicleListing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int listingId;
	private String vehicleNo;
	private Double pricePerDay;
	private SeatingType seating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User rentingPartner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;
	
	public int getListingId() {
		return listingId;
	}
	
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	public Double getPricePerDay() {
		return pricePerDay;
	}
	
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public SeatingType getSeating() {
		return seating;
	}
	
	public void setSeating(SeatingType seating) {
		this.seating = seating;
	}
	
	public User getRentingPartner() {
		return rentingPartner;
	}
	
	public void setRentingPartner(User rentingPartner) {
		this.rentingPartner = rentingPartner;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
