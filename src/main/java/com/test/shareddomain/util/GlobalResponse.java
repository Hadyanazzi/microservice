package com.test.shareddomain.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalResponse<T>{

    protected String timestamp;

    @JsonProperty("code")
    protected Integer code;

    @JsonProperty("app_code")
    protected String appCode;

    @JsonProperty("description")
    protected StatusCode description;

    @JsonProperty("message")
    protected String message;

    @JsonProperty("result")
    protected T result;
}