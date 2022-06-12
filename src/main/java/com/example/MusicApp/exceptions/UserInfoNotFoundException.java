package com.example.MusicApp.exceptions;

public class UserInfoNotFoundException extends RuntimeException{

    public UserInfoNotFoundException() {
        super("UserInfo not associated with this User");
    }

    public UserInfoNotFoundException(String message) {
        super(message);
    }
}
