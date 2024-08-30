package com.test.shareddomain.util;

import org.springframework.http.HttpStatus;

public enum StatusCode {
    SUCCESS(200, "Success"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_FOUND(404, "Not Found"),
    OK(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()),
    BAD_REQUEST(400, "Bad Request");

    private final int code;
    private final String description;

    StatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getCodeDesc() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.valueOf(code);
    }

    public String getMessage() {
        return description;
    }
}