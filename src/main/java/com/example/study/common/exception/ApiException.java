package com.example.study.common.exception;

import com.example.study.common.constants.ApiExceptionType;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    ApiExceptionType apiExceptionType;

    public ApiException(ApiExceptionType apiExceptionType) {
        super(apiExceptionType.getMessage());
        this.apiExceptionType = apiExceptionType;
    }
}
