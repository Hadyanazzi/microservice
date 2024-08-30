package com.test.shareddomain.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.shareddomain.message.BaseErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {
    @JsonProperty("field_error_list")
    private List<BaseErrorMessage> fieldErrorList;
    private Object message;

    private Object data;
}
