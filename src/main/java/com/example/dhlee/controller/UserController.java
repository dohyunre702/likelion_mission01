package com.example.dhlee.controller;

import com.example.dhlee.domain.dto.Response;
import com.example.dhlee.domain.dto.UserDto;
import com.example.dhlee.domain.dto.UserJoinRequest;
import com.example.dhlee.domain.dto.UserJoinResponse;
import com.example.dhlee.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest userJoinRequest) {
        UserDto userDto = userService.join(userJoinRequest);
        return Response.success(new UserJoinResponse(userDto.getId(), userDto.getUsername())); //

    }

}
