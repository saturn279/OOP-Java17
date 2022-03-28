package com.app.custom_exceptions;

public class InvalidEmployeeId extends Exception {

    public InvalidEmployeeId(String message) {
        super(message);
    }
    
}
