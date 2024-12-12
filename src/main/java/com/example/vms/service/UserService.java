package com.example.vms.service;

import org.springframework.stereotype.Service;

import com.example.vms.entity.User;
import com.example.vms.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	

}
