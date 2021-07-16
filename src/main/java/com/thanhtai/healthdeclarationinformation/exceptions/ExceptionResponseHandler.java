package com.thanhtai.healthdeclarationinformation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    private final String ALREADY_EXISTED = "Object already exited";
    private final String NOT_FOUND = "Not found";

    @ExceptionHandler(AlreadyExistedException.class)
    public final ResponseEntity<ExceptionResponse> handleAlreadyExistedException(AlreadyExistedException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), HttpStatus.ALREADY_REPORTED.value(),
                ALREADY_EXISTED, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
                NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
