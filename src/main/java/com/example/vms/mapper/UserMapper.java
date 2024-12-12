package com.example.vms.mapper;

import com.example.vms.entity.User;
import com.example.vms.requestdto.UserRequest;
import com.example.vms.responsedto.UserResponse;

public class UserMapper {
	
	private final UserRequest userRequest;
	private final UserResponse userResponse;
	
	public UserMapper(UserRequest userRequest, UserResponse userResponse) {
		super();
		this.userRequest = userRequest;
		this.userResponse = userResponse;
	}
	
	public User mapToUser(UserRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(request.getRole());
		
		return user;
	}
	
	public UserResponse mapToUserResponse(User user) {
		
		UserResponse response = new UserResponse();
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setRole(user.getRole());
		
		return response;
	}

}
