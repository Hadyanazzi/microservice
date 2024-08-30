package com.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserResponseDto {
    private Long userId;
    private String name;
}