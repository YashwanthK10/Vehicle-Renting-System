package com.example.vms.security;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.vms.entity.User;
import com.example.vms.repository.UserRepository;

@Component
public class AuthUtil {
	
	private final UserRepository userRepository;

	public AuthUtil(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication(); // to access the authentication object we are using SecurityContextHolder class.         
		// getContext -> static method.
	}
	
	public String getCurrentUsername() {
		return getAuthentication().getName();
	}
	
	public User getCurrentUser() {
		return userRepository.findByEmail(getCurrentUsername())
				.orElseThrow(() -> new UsernameNotFoundException("Failed to get current User"));
	}

}
