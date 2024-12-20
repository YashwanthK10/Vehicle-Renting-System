package com.example.vms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vms.requestdto.VehicleListingRequest;
import com.example.vms.responsedto.VehicleListingResponse;
import com.example.vms.service.VehicleListingService;
import com.example.vms.util.ResponseStructure;

@RestController
public class VehicleListingController {
	
	private final VehicleListingService  vehicleListingService;

	public VehicleListingController(VehicleListingService vehicleListingService) {
		super();
		this.vehicleListingService = vehicleListingService;
	}
	
	@PostMapping("/insert-vehicle-listing")
    public ResponseEntity<ResponseStructure<VehicleListingResponse>> insertVehicleListing(
    		@RequestBody VehicleListingRequest request, @RequestParam("vehicleId") int vehicleId) {
        VehicleListingResponse response = vehicleListingService.insertVehicleList(request, vehicleId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseStructure.create(HttpStatus.CREATED.value(), "Vehicle Listing Created Successfully", response));
    }
	
	@GetMapping("/find-all-vehicle-listings")
    public ResponseEntity<ResponseStructure<List<VehicleListingResponse>>> getAllVehicleListings(@RequestParam("vehicleId") int vehicleId) {
        List<VehicleListingResponse> vehicleListings = vehicleListingService.findAllVehicleListings(vehicleId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseStructure.create(HttpStatus.OK.value(), "Vehicle Listings Retrieved Successfully", vehicleListings));
    }
	
}
