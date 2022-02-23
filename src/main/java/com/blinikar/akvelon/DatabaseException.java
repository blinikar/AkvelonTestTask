package com.blinikar.akvelon;

public class DatabaseException extends Exception {

    public DatabaseException() {
        super("Unknown Database Exception");
    }

    @SuppressWarnings("unused")
    public DatabaseException(String message) {
        super(message);
    }
}
