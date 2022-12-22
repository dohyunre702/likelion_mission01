package com.example.dhlee.exception;

//RuntimeException을 상속받은 SignException 클래스
public class SignException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public String toString() {
        if(message == null) return errorCode.getMessage();
        return String.format("%s. %s", errorCode.getMessage(), message);
    }
}
