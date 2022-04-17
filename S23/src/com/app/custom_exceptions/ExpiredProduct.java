package com.app.custom_exceptions;

public class ExpiredProduct extends Exception {

	public ExpiredProduct() {
		super("Product expiryDate before today.");
	}

	

}
