package com.app.custom_exceptions;

public class InvalidTransactionDate extends Exception {


	private static final long serialVersionUID = 1L;

	public InvalidTransactionDate(String message) {
		super(message);
	}


}
