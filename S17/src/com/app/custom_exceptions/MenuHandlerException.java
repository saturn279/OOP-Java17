package com.app.custom_exceptions;

public class MenuHandlerException extends Exception {

    public MenuHandlerException(String message) {
        super("\n----------[ "+message+" ]----------\n");
    }
    
}
