package com.learning.exception;

public class MongoException extends RuntimeException {

    public MongoException(String message) {
        super(message);
    }
}
