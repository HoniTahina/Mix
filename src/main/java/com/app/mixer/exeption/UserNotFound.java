package com.app.mixer.exeption;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String s) {
        super(s);
    }
}
