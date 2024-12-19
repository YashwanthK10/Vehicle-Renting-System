package com.example.vms.responsedto;

import java.util.List;

import com.example.vms.enums.FuelType;
import com.example.vms.enums.VehicleType;

public class VehicleResponse {
	
	private int vehicleId;
	private String brand;
	private VehicleType type;
	private String model;
	private FuelType fuelType;
	//private List<String> vehicleImagesLink;
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public VehicleType getType() {
		return type;
	}
	
	public void setType(VehicleType type) {
		this.type = type;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public FuelType getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	
	
}
