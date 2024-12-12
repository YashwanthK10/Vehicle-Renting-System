package com.example.vms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vms.entity.User;
import com.example.vms.service.UserService;
import com.example.vms.util.BasicResponse;
import com.example.vms.util.ResponseStructure;

@RestController
public class UserController {
	
	private UserService userService;

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
	
	@PostMapping("/upload-picture")
	public ResponseEntity<BasicResponse> uploadPicture(@RequestParam ("userId") int userId, 
							@RequestParam ("file") MultipartFile file){
		userService.uploadPicture(userId, file);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(BasicResponse.create(HttpStatus.CREATED.value(), "User Profile Picture is Updated"));
		
	}

}
