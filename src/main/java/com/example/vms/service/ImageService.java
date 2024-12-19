package com.example.vms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vms.entity.Image;
import com.example.vms.entity.User;
import com.example.vms.entity.Vehicle;
import com.example.vms.exception.FailedToUploadException;
import com.example.vms.exception.ImageNotFoundById;
import com.example.vms.exception.UserNotFoundException;
import com.example.vms.repository.ImageRepository;
import com.example.vms.repository.UserRepository;
import com.example.vms.repository.VehicleRepository;

@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	private final UserRepository userRepository;
	private final VehicleRepository vehicleRepository;

	public ImageService(ImageRepository imageRepository, UserRepository userRepository, VehicleRepository vehicleRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
		this.vehicleRepository = vehicleRepository;
	}

	public void uploadPicture(int userId, MultipartFile file) {
		
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			
			User user = optional.get();
			
			if(user.getProfilePicture() != null) {
				Image image = user.getProfilePicture();
				this.uploadUserProfile(file, user);
				imageRepository.delete(image);
			}
			
			this.uploadUserProfile(file, user);
			
		}
		else {
			throw new FailedToUploadException("Failed to upload image");
		}
		
	}
	
	private void uploadUserProfile(MultipartFile file, User user) {
		
		Image image = imageRepository.save(this.getImage(file)); 
		user.setProfilePicture(image);
		userRepository.save(user);
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

	public Image fetchImage(int imageId) {
		
		Optional<Image> optional = imageRepository.findById(imageId);
		if(optional.isPresent()) {
			Image image = optional.get();
			return image;
		}
		else {
			throw new ImageNotFoundById("Image is not there in database");
		}
	}

	public void uploadVehicleImages(int vehicleId, List<MultipartFile> files) {
		
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new UserNotFoundException("Vehicle not found with ID: " + vehicleId));

		List<Image> images = new ArrayList();

		for (MultipartFile file : files) {
			images.add(this.getImage(file));
		}

		images = imageRepository.saveAll(images);
		vehicle.setImages(images);
		vehicleRepository.save(vehicle);
		
	}	
	
	
}
