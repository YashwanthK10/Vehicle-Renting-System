package com.example.vms.mapper;

import org.springframework.stereotype.Component;

import com.example.vms.entity.Vehicle;
import com.example.vms.requestdto.VehicleRequest;
import com.example.vms.responsedto.VehicleResponse;

@Component
public class VehicleMapper {
	
	public Vehicle mapToVehicle(VehicleRequest request, Vehicle vehicle) {
		
		vehicle.setBrand(request.getBrand());
		vehicle.setType(request.getType());
		vehicle.setModel(request.getModel());
		vehicle.setFuelType(request.getFuelType());
		
		return vehicle;
	}
	
	public VehicleResponse mapToVehicleResponse(Vehicle vehicle) {
		
		VehicleResponse response = new VehicleResponse();
		
		response.setVehicleId(vehicle.getVehicleId());
		response.setBrand(vehicle.getBrand());
		response.setType(vehicle.getType());
		response.setModel(vehicle.getModel());
		response.setFuelType(vehicle.getFuelType());
		
		return response;
	}

}
