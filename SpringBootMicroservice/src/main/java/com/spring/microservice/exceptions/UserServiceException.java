package com.spring.microservice.exceptions;

public class UserServiceException extends RuntimeException{

	private static final long serialVersionUID = -3420433339608923949L;
	public UserServiceException(String message) {
		super(message);
	}

}
