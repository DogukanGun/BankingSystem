package com.dag.bankingsystem.exception.handler;

import com.dag.bankingsystem.exception.ApiException;
import com.dag.bankingsystem.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleErrorResponse(ApiException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .responseType(exception.getClass().getSimpleName())
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity.status(exception.getHttpStatus()).body(errorResponse);
    }
}
