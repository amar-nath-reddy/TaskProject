package com.pocproject.TaskProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFount extends RuntimeException {
	private String message;
	
	public UserNotFount(String message) {
		super(message);
		this.message = message;
	}

}
