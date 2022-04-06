package com.app.custom_exception;

public class MenuHandlerException extends Exception {

    public MenuHandlerException(String message) {
        super("\n----------[ "+message+" ]----------\n");
    }
    
}
