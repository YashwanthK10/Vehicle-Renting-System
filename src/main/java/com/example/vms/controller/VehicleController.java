package com.example.vms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vms.entity.Vehicle;
import com.example.vms.requestdto.VehicleRequest;
import com.example.vms.responsedto.VehicleResponse;
import com.example.vms.service.VehicleService;
import com.example.vms.util.ResponseStructure;

@RestController
public class VehicleController {
	
	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}
	
	@PostMapping("/save-vehicle")
	public ResponseEntity<ResponseStructure<VehicleResponse>> addVehicle(@RequestBody VehicleRequest request) {

		VehicleResponse response = vehicleService.addVehicle(request);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Employee Created", response));
	}

	@GetMapping("/find-all-vehicle")
	public ResponseEntity<ResponseStructure<List<Vehicle>>> findAllVehicle() {

		List<Vehicle> vehicles = vehicleService.findAllVehicle();

		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(), "Employees are found", vehicles));
	}
	
	@PutMapping("/update-vehicle")
	public ResponseEntity<ResponseStructure<VehicleResponse>> updateVehicle(@RequestBody VehicleRequest request, @RequestParam int vehicleId) {

		VehicleResponse response = vehicleService.updateVehicle(request, vehicleId);

		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "Updated Successfully", response));
	}

}
