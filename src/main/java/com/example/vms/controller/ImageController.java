package com.example.vms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vms.entity.Image;
import com.example.vms.service.ImageService;
import com.example.vms.util.BasicResponse;

@RestController
public class ImageController {
	
	private final ImageService imageService;

	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/upload-picture")
	public ResponseEntity<BasicResponse> uploadPicture(@RequestParam ("userId") int userId, 
							@RequestParam ("file") MultipartFile file){
		imageService.uploadPicture(userId, file);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(BasicResponse.create(HttpStatus.CREATED.value(), "Profile Picture is Updated"));
	}
	
	@PostMapping("/fetch-image")
	public ResponseEntity<byte[]> fetchImage(@RequestParam ("imageId") int imageId){
		
		Image image = imageService.fetchImage(imageId);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf(image.getContentType()))
				.body(image.getImageBytes());
		
	}
	
}
