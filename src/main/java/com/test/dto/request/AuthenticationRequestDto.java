package com.test.dto.request;


import lombok.Data;


@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
