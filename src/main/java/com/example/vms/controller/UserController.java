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
	
	@PostMapping("/save-user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		user = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));
	}
	
	@PostMapping("/customer-register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerCustomer(@RequestBody UserRequest userRequest){
		UserResponse userResponse = userService.registerCustomer(userRequest, UserRole.CUSTOMER);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Customer role is Created", userResponse));
	}
	
	@PostMapping("/renting-partner-register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerRentingPartner(@RequestParam UserRequest userRequest){
		UserResponse userResponse = userService.registerRentingPartner(userRequest, UserRole.RENTING_PARTNER);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "RentingPartner role is created", userResponse));
	}
	
	@GetMapping("/fetch-user")
	public ResponseEntity<ResponseStructure<UserResponse>> getUserWithImage(@RequestParam ("userId") int userId){
		UserResponse response = userService.getUserWithImage(userId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "User Fetched successfully", response));
	}
	
}
