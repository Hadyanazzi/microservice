package com.test.shareddomain.dto.response;

import com.test.shareddomain.util.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
@AllArgsConstructor
public class BusinessFailedException extends RuntimeException implements Serializable {

    private final StatusCode statusCode;

    private final String message;

    private final String field;
    private final Boolean isUsingField;

    public BusinessFailedException(String field, String message, StatusCode statusCode) {
        this.message = message;
        this.field = field;
        this.statusCode = statusCode;
        this.isUsingField = true;
    }

    public BusinessFailedException(String field, String message, StatusCode statusCode, Boolean isUsingField) {
        this.message = message;
        this.field = field;
        this.statusCode = statusCode;
        this.isUsingField = isUsingField;
    }

    public BusinessFailedException(String user, String notFoundErrorMessage, ResponseEntity.HeadersBuilder<?> headersBuilder) {
        this.message = notFoundErrorMessage;
        this.field = user;
        this.statusCode = StatusCode.INTERNAL_SERVER_ERROR; // Assuming a default value
        this.isUsingField = false; // Assuming a default value
    }
}