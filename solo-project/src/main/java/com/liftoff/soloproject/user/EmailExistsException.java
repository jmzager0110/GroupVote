package com.liftoff.soloproject.user;

public class EmailExistsException extends Exception{

    public EmailExistsException(String message) {
        super(message);
    }
}
