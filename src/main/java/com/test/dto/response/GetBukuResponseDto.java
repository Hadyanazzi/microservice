package com.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetBukuResponseDto {
    private String userId;
    private String name;
}