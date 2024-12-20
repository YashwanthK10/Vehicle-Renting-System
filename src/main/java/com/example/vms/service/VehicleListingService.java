package com.example.vms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vms.entity.Vehicle;
import com.example.vms.entity.VehicleListing;
import com.example.vms.mapper.VehicleListingMapper;
import com.example.vms.repository.VehicleListingRepository;
import com.example.vms.repository.VehicleRepository;
import com.example.vms.requestdto.VehicleListingRequest;
import com.example.vms.responsedto.VehicleListingResponse;

@Service
public class VehicleListingService {

	private final VehicleListingRepository vehicleListingRepository;
	private final VehicleListingMapper vehicleListingMapper;
	private final VehicleRepository vehicleRepository;
	

	public VehicleListingService(VehicleListingRepository vehicleListingRepository, VehicleListingMapper vehicleListingMapper, VehicleRepository vehicleRepository) {
		super();
		this.vehicleListingRepository = vehicleListingRepository;
		this.vehicleListingMapper = vehicleListingMapper;
		this.vehicleRepository = vehicleRepository;
		
	}

	public VehicleListingResponse insertVehicleList(VehicleListingRequest request, int vehicleId) {

		 Vehicle vehicle = vehicleRepository.findById(vehicleId)
	                .orElseThrow(() -> new IllegalArgumentException("Vehicle with ID " + vehicleId + " does not exist."));

	        VehicleListing vehicleListing = vehicleListingMapper.mapToVehicleListing(request, new VehicleListing());
	        vehicleListing.setVehicle(vehicle);
	        VehicleListing savedListing = vehicleListingRepository.save(vehicleListing);
	        return vehicleListingMapper.mapToVehicleListingResponse(savedListing);
	}

	public List<VehicleListingResponse> findAllVehicleListings(int vehicleId) {
		
	    List<VehicleListing> vehicleListings = vehicleListingRepository.findVehicleListings_ByVehicleId(vehicleId);

	    List<VehicleListingResponse> responseList = new ArrayList<VehicleListingResponse>();

	    for (VehicleListing vehicleListing : vehicleListings) {
	        
	        responseList.add(vehicleListingMapper.mapToVehicleListingResponse(vehicleListing));
	    }

	    return responseList;
	}

}
