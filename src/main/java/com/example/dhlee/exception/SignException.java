package com.example.dhlee.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignException extends RuntimeException {
    //RuntimeException을 상속받은 SignException 클래스
    private ErrorCode errorCode;
    private String message;

    public String toString() {
        if(message == null) return errorCode.getMessage();
        return String.format("%s. %s", errorCode.getMessage(), message);
    }
}
