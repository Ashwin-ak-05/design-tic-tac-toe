package org.example.exceptions;

public class InvalidPlayerCount extends RuntimeException {
    public InvalidPlayerCount(String message) {
        super(message);
    }
}
