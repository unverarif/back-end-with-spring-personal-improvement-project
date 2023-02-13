package com.arifunver.backendwithspring.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId) {
        super("Could not found the user with userId: " + userId);
    }
}
