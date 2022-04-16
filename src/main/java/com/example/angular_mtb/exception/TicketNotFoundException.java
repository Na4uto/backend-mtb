package com.example.angular_mtb.exception;

public class TicketNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TicketNotFoundException(String msg) {
		super(msg);
	}
}
