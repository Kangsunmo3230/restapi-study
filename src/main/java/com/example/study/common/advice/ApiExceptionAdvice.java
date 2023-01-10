package com.example.study.common.advice;

import com.example.study.common.constants.ApiExceptionType;
import com.example.study.common.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(HttpServletRequest request, final Exception e) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        if(e instanceof ApiException) {
            ApiExceptionType apiException = ((ApiException) e).getApiExceptionType();
            responseEntity = ResponseEntity
                    .status(apiException.getStatus())
                    .header("errorMessage", apiException.getMessage())
                    .header("errorCode", String.valueOf(apiException.getCode()))
                    .body(null);
        }

        return responseEntity;
    }
}
