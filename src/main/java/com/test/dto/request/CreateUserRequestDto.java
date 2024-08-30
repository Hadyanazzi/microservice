package com.test.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateUserRequestDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("username")
    private String username;

}


