package com.test.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UpdateBukuRequestDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("name")
    private String name;

}


