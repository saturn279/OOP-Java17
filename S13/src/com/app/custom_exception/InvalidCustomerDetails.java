package com.app.custom_exception;

public class InvalidCustomerDetails extends Exception {

    public InvalidCustomerDetails(String message) {
        super("\n----------[ "+message+" ]----------\n");
    }
    
}
