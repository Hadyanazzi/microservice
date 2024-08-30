package com.test.controllers.transform;

import com.test.dto.request.AuthenticationRequestCommand;
import com.test.dto.request.AuthenticationRequestDto;
import com.test.dto.request.RegisterRequestCommand;
import com.test.dto.request.RegisterRequestDto;

public class AuthDTOAssembler {

    public static RegisterRequestCommand toRegisterUserCommand(RegisterRequestDto requestDto) {
        return RegisterRequestCommand.builder()
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .token(requestDto.getToken())
                .build();
    }

    public static AuthenticationRequestCommand toLoginRequestCommand(AuthenticationRequestDto requestDto) {
        return AuthenticationRequestCommand.builder()
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .build();
    }
}
