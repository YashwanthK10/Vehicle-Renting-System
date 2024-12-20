package com.example.vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.vms.entity.VehicleListing;

public interface VehicleListingRepository extends JpaRepository<VehicleListing, Integer>{
	
	@Query("SELECT v FROM VehicleListing v WHERE v.vehicle.id = :vehicleId")
	List<VehicleListing> findVehicleListings_ByVehicleId(int vehicleId);


}
