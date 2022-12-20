package com.ienglish.controller;

import com.ienglish.model.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandleController {
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<APIResponse> illegalArgException(){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setSuccess(false);
        apiResponse.setMessage("Request Data Error");
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<APIResponse> error(){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setSuccess(false);
        apiResponse.setMessage("Service Internal Error");
        return new ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
