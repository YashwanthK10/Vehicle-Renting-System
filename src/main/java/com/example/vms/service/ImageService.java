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
public class ImageService {
	
	private final ImageRepository imageRepository;
	private final UserRepository userRepository; 

	public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
	}

	public void uploadPicture(int userId, MultipartFile file) {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			
			Image image = imageRepository.save(this.getImage(file)); 
			
			User user = optional.get();
			user.setProfilePicture(image);
			userRepository.save(user);
		}
		else {
			throw new FailedToUploadException("Failed to upload image");
		}
		
	}

	public Image getImage(MultipartFile file) {
		
		try {
			Image image = new Image();
			image.setContentType(file.getContentType());
			image.setImageBytes(file.getBytes());
			return image;
		} 
		catch(Exception e) {
			throw new FailedToUploadException("Failed to get image");
		}
	}	
	
}
