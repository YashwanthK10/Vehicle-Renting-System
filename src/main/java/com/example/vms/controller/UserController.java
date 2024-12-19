package com.example.vms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vms.entity.User;
import com.example.vms.enums.UserRole;
import com.example.vms.requestdto.UserRequest;
import com.example.vms.responsedto.UserResponse;
import com.example.vms.service.UserService;
import com.example.vms.util.ResponseStructure;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/admin-register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerAdmin(@RequestBody UserRequest request) {

		UserResponse response = userService.register(request, UserRole.ADMIN);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Admin created", response));

	}

	@PostMapping("/customer-register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerCustomer(@RequestBody UserRequest request) {
		UserResponse response = userService.register(request, UserRole.CUSTOMER);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Customer Created", response));

	}

	@PostMapping("/renting-partner-register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerRentingPartner(@RequestBody UserRequest request) {
		UserResponse response = userService.register(request, UserRole.RENTING_PARTNER);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Renting Partner Created", response));

	}

	@GetMapping("/fetch-user")
	public ResponseEntity<ResponseStructure<UserResponse>> getUserWithImage(@RequestParam("userId") int userId) {
		UserResponse response = userService.getUserWithImage(userId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "User Fetched successfully", response));
	}

	@PutMapping("/update-user")
	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest request,
			@RequestParam int userId) {
		UserResponse response = userService.updateUser(request, userId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "User Updated", response));
	}

}
