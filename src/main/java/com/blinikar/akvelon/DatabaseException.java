package com.blinikar.akvelon;

public class DatabaseException extends Exception {

    public DatabaseException() {
        super("Unknown Database Exception");
    }

    public DatabaseException(String message) {
        super(message);
    }
}
