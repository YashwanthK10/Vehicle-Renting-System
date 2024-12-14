package com.example.vms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vms.entity.User;
import com.example.vms.enums.UserRole;
import com.example.vms.exception.UserNotFoundException;
import com.example.vms.mapper.UserMapper;
import com.example.vms.repository.UserRepository;
import com.example.vms.requestdto.UserRequest;
import com.example.vms.responsedto.UserResponse;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserResponse register(UserRequest request, UserRole role) {

		User user = userMapper.mapToUser(request, new User());
		user.setRole(role);
		User savedUser = userRepository.save(user);
		return userMapper.mapToUserResponse(savedUser);
	}

	public UserResponse getUserWithImage(int userId) {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent()) {
			
			User user = optional.get();
			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, user.getUserId());
			
			return response;
		} 
		else {
			throw new UserNotFoundException("User not found with given id: " + userId);
		}

	}

	private void setProfilePictureURL(UserResponse response, int userId) {
		int imageId = userRepository.getProfilePictureIdByUserId(userId);
		if (imageId > 0) {
			response.setProfilePictureLink("/fetch-image?imageId=" + imageId);
		}

	}

	public UserResponse updateUser(UserRequest request, int userId) {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent()) {
			
			User user = userMapper.mapToUser(request, optional.get());
			userRepository.save(user);

			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, userId);
			
			return response;
		} 
		else {
			throw new UserNotFoundException("Failed To Find The User");
		}

	}

}
