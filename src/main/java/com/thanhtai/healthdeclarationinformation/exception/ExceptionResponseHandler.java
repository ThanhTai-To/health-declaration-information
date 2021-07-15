package com.thanhtai.healthdeclarationinformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    private final String ALREADY_EXISTED = "Already exited object";

    @ExceptionHandler(AlreadyExistedException.class)
    public final ResponseEntity<ExceptionResponse> handleAlreadyExistedException(AlreadyExistedException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), HttpStatus.ALREADY_REPORTED.value(),
                ALREADY_EXISTED, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.ALREADY_REPORTED);
    }
}
