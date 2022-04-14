package com.app.custom_exceptions;

public class StudentNotFound extends Exception{
	
	public StudentNotFound() {
		super("Student with given id not found.");
	}
}
