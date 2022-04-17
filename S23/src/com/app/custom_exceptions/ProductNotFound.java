package com.app.custom_exceptions;

public class ProductNotFound extends Exception {

	public ProductNotFound(String message) {
		super("Product "+ message + " not found.");
	}

	
}
