package com.example.dhlee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "중복된 회원입니다.");

    //커스텀용 변수
    private HttpStatus status;
    private String message;
}
