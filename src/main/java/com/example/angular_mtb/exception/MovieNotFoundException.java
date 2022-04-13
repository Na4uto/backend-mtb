package com.example.angular_mtb.exception;

public class MovieNotFoundException extends Exception {

	public MovieNotFoundException() {

	}

	public MovieNotFoundException(String message) {
		super(message);
	}
}
