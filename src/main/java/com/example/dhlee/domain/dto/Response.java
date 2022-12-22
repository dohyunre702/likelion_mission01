package com.example.dhlee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response<T> {
    private String resultCode;
    private T result;

    public static Response<Void> error(String resultCode) {
        return new Response<>(resultCode, null);
        //(resultCode;어떤 에러인지 표시, null;기능추가)
    }

    public static <T> Response<T> success(T result) { //매개변수 T result
        return new Response<>("SUCCESS", result);
        //(성공 메시지, 제네릭: 주로 UserResponse(userName, emailAddress) 형식으로 리턴)
    }
}
