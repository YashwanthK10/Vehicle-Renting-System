package com.example.vms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vms.entity.Image;
import com.example.vms.entity.User;
import com.example.vms.exception.FailedToUploadException;
import com.example.vms.exception.UserNotFoundException;
import com.example.vms.repository.ImageRepository;
import com.example.vms.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final ImageRepository imageRepository;

	public UserService(UserRepository userRepository, ImageRepository imageRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository = imageRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void uploadPicture(int userId, MultipartFile file) {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			Image image = getImage(file);
			image = imageRepository.save(image);
			
			User user = optional.get();
			user.setProfilePicture(image);
			userRepository.save(user);
		}
		else {
			throw new UserNotFoundException("User Not Found");
		}
		
	}

	private Image getImage(MultipartFile file) {
		
		Image image = new Image();
		
		try {
			byte[] imageBytes = file.getBytes();
			image.setContentType(file.getContentType());
			image.setImageBytes(imageBytes);
			imageRepository.save(image);
		} 
		catch(Exception e) {
			throw new FailedToUploadException("Failed to upload image");
		}
		
		return image;
	}
	
	

}
