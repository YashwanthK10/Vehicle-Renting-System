package com.example.vms.entity;

import java.util.List;

import com.example.vms.enums.FuelType;
import com.example.vms.enums.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String brand;
	private VehicleType type;
	private String model;
	private FuelType fuelType;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Image> images;
	
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
