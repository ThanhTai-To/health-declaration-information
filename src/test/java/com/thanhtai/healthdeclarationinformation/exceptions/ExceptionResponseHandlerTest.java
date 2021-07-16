package com.thanhtai.healthdeclarationinformation.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class ExceptionResponseHandlerTest {

    private final String ALREADY_EXISTED = "Object already exited";
    private final String NOT_FOUND = "Not found";
    private final String CUSTOMIZED_MESSAGE = "Customized message";

    @Autowired
    private ExceptionResponseHandler handler;

    @Test
    void testHandleAlreadyExistedException() {
        AlreadyExistedException exception = new AlreadyExistedException(CUSTOMIZED_MESSAGE);
        ResponseEntity<ExceptionResponse> response = handler.handleAlreadyExistedException(exception);
        assertEquals(208, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(ALREADY_EXISTED, response.getBody().getError());
        assertEquals(CUSTOMIZED_MESSAGE, response.getBody().getErrorMessage());
    }

    @Test
    void testHandleNotFoundException() {
        NotFoundException exception = new NotFoundException(CUSTOMIZED_MESSAGE);
        ResponseEntity<ExceptionResponse> response = handler.handleNotFoundException(exception);
        assertEquals(404, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(NOT_FOUND, response.getBody().getError());
        assertEquals(CUSTOMIZED_MESSAGE, response.getBody().getErrorMessage());
    }
}
