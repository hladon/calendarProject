package com.calendar.calendar.exceptions;

public class NoSuchEntity extends Exception {
    @Override
    public String getMessage() {
        return "Such entity doesnt exist in repository!";
    }
}
