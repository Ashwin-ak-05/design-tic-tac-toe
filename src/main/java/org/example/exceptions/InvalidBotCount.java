package org.example.exceptions;

public class InvalidBotCount extends RuntimeException {
    public InvalidBotCount(String message) {
        super(message);
    }
}
