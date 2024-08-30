package com.test.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RegisterLoginResponseDto extends AuthenticationResponseCommand {
    private String username;
    private String password;

    public RegisterLoginResponseDto(String username, String password, AuthenticationResponseCommand responseJwt) {
        this.username=username;
        this.password= password;
        setAccessToken(responseJwt.getAccessToken());
        setExpiredTime(responseJwt.getExpiredTime());
        setRefreshToken(responseJwt.getRefreshToken());
        setRefreshExpiredTime(responseJwt.getRefreshExpiredTime());
    }

}
