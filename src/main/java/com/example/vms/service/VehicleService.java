package com.example.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vms.entity.Vehicle;
import com.example.vms.exception.VehicleNotFoundExcepction;
import com.example.vms.mapper.VehicleMapper;
import com.example.vms.repository.VehicleRepository;
import com.example.vms.requestdto.VehicleRequest;
import com.example.vms.responsedto.VehicleResponse;

@Service
public class VehicleService {
	
	private final VehicleRepository vehicleRepository;
	private final VehicleMapper vehicleMapper;

	public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.vehicleMapper = vehicleMapper;
	}

	public VehicleResponse addVehicle(VehicleRequest request) {
		
		Vehicle vehicle = vehicleMapper.mapToVehicle(request, new Vehicle());
		vehicle = vehicleRepository.save(vehicle);
		
		VehicleResponse response = vehicleMapper.mapToVehicleResponse(vehicle);
		return response;
	}

	public List<Vehicle> findAllVehicle() {

		List<Vehicle> vehicles = vehicleRepository.findAll();

		if (vehicles.size() != 0) {
			return vehicles;
		} else {
			throw new VehicleNotFoundExcepction("There are no Vehicles to display");
		}

	}

	public VehicleResponse updateVehicle(VehicleRequest request, int vehicleId) {
		
		Optional<Vehicle> optional = vehicleRepository.findById(vehicleId);
		
		if (optional.isPresent()) {
			Vehicle vehicle = vehicleMapper.mapToVehicle(request, optional.get());
			vehicle = vehicleRepository.save(vehicle);
			
			return vehicleMapper.mapToVehicleResponse(vehicle);
		}
		else {
			throw new VehicleNotFoundExcepction("Vehicle with such id is not found");
		}
	}

}
