package com.app.custom_exceptions;

public class InvalidTransactionAmount extends Exception {


	private static final long serialVersionUID = 1L;

	public InvalidTransactionAmount(String message) {
		super(message);
	}


}
