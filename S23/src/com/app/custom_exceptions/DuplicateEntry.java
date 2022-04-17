package com.app.custom_exceptions;

public class DuplicateEntry extends Exception {

	public DuplicateEntry() {
		super("Product entry already exists.");
	}

	
}
