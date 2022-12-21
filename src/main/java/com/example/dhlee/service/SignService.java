package com.example.dhlee.service;

import com.example.dhlee.domain.dto.*;

public interface SignService {
    UserJoinResponse signUp (UserJoinRequest userJoinRequest); //회원가입
    UserLoginResponse signIn (UserLoginRequest userLoginRequest); //로그인

}
