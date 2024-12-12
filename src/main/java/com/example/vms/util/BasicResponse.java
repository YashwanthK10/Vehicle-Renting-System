package com.example.vms.util;

public class BasicResponse {
	
	private int status;
	private String message;
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static BasicResponse create(int status, String message) {
		BasicResponse response = new BasicResponse();
		response.setStatus(status);
		response.setMessage(message);
		
		return response;
	}

}
