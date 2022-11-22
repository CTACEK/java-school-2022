package ru.croc.task13.exceptions;

public class UserNotFoundException extends Exception {

    private final Integer userId;

    public UserNotFoundException(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return "User ID " + userId + " not found in database";
    }
}
