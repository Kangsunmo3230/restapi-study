package com.example.study.common.constants;

import org.springframework.http.HttpStatus;

public enum ApiExceptionType {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 4000000),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, 401001, "token expired"),
    BAD_TOKEN(HttpStatus.UNAUTHORIZED, 401002, "token exception"),
    NO_DATA(HttpStatus.NOT_FOUND, 404001, "no data"),
    INTERNAL_SERVER(HttpStatus.INTERNAL_SERVER_ERROR, 500000),
    ;

    private HttpStatus status;
    private int code;
    private String message;

    ApiExceptionType(HttpStatus status, int code) {
        this.status = status;
        this.code = code;
    }

    ApiExceptionType(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
