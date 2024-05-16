package com.gk.hotelservices.exception;

import com.gk.hotelservices.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> handlerResponseNotFoundException(ResourceNotFound exception){
        ApiResponse apiResponse = ApiResponse.builder()
                .message(exception.getMessage())
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
