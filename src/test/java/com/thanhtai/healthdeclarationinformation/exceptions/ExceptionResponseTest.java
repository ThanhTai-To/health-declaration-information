package com.thanhtai.healthdeclarationinformation.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ExceptionResponseTest {

    @Test
    void testNoArgsConstructor() {
        ExceptionResponse exception = new ExceptionResponse();
        assertNull(exception.getError());
        assertNull(exception.getErrorMessage());
        assertEquals(0, exception.getStatus());
        assertNull(exception.getTimestamp());
    }

    @Test
    void testAllArgsConstructor() {
        Date timestamp = new Date();
        int status = 404;
        String error = HttpStatus.NOT_FOUND.toString();
        String errorMessage = "Object not found";
        ExceptionResponse exception = new ExceptionResponse(timestamp, status, error, errorMessage);
        assertEquals(timestamp, exception.getTimestamp());
        assertEquals(status, exception.getStatus());
        assertEquals(error, exception.getError());
        assertEquals(errorMessage, exception.getErrorMessage());
    }
}
