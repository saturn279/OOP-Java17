package com.ipl.custom_exceptions;

public class InvalidPlayerDetails extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidPlayerDetails(String message) {
		super(message);
	}

}
