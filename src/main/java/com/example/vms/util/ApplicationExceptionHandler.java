package com.example.vms.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vms.exception.FailedToUploadException;
import com.example.vms.exception.UserNotFoundException;
import com.example.vms.exception.VehicleNotFoundExcepction;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFound(UserNotFoundException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "User Not Found by given Id"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleFailedToUpload(FailedToUploadException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Failed to upload the Image"));
	}
	
	/*@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUsernameNotFoundException(UsernameNotFoundException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "User not found"));
	}*/
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleVehicleNotFoundExcepction(VehicleNotFoundExcepction ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to Find the Vehicle"));
	}
}
