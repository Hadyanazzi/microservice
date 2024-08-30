package com.test.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequestCommand {
    private String username;
    private String password;
}