package com.example.vms.mapper;

import org.springframework.stereotype.Component;

import com.example.vms.entity.User;
import com.example.vms.enums.UserRole;
import com.example.vms.requestdto.UserRequest;
import com.example.vms.responsedto.UserResponse;

@Component
public class UserMapper {

	public User mapToCustomer(UserRequest request, UserRole role) {

		User user = new User();

		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(role);

		return user;
	}

	public User mapToRentingPartner(UserRequest request, UserRole role) {
		
		User user = new User();

		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(role);

		return user;
	}

	public UserResponse mapToUserResponse(User user) {

		UserResponse response = new UserResponse();

		response.setUserId(user.getUserId());
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setRole(user.getRole());

		return response;
	}

}
