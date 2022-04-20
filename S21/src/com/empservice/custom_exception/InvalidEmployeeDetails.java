package com.empservice.custom_exception;

public class InvalidEmployeeDetails extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidEmployeeDetails(String message) {
		super(message);
	}

}
