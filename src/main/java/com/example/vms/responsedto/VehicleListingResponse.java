package com.example.vms.responsedto;

import com.example.vms.enums.SeatingType;

public class VehicleListingResponse {
	
	private int listingId;
	private String vehicleNo;
	private Double pricePerDay;
	private SeatingType seating;
	
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
	
}
