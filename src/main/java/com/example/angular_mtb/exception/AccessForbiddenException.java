package com.example.angular_mtb.exception;

public class AccessForbiddenException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccessForbiddenException(String message) {
		super(message);
	}
}
