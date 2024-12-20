package com.example.vms.mapper;

import org.springframework.stereotype.Component;

import com.example.vms.entity.VehicleListing;
import com.example.vms.requestdto.VehicleListingRequest;
import com.example.vms.responsedto.VehicleListingResponse;

@Component
public class VehicleListingMapper {
	
	public VehicleListing mapToVehicleListing(VehicleListingRequest request, VehicleListing vehicleListing) {
		
		vehicleListing.setVehicleNo(request.getVehicleNo());
		vehicleListing.setPricePerDay(request.getPricePerDay());
		vehicleListing.setSeating(request.getSeating());
		
		return vehicleListing;
	}
	
	public VehicleListingResponse mapToVehicleListingResponse(VehicleListing vehicleListing) {
		
		VehicleListingResponse response = new VehicleListingResponse();
		
		response.setListingId(vehicleListing.getListingId());
		response.setVehicleNo(vehicleListing.getVehicleNo());
		response.setPricePerDay(vehicleListing.getPricePerDay());
		response.setSeating(vehicleListing.getSeating());
		
		return response;
	}
	

}
