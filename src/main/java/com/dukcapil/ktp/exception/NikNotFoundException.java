package com.dukcapil.ktp.exception;

public class NikNotFoundException extends RuntimeException {
    public NikNotFoundException() {
        super();
    }

    public NikNotFoundException(String message) {
        super(message);
    }

    public NikNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
