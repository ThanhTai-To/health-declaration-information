package com.thanhtai.healthdeclarationinformation.api.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectSuccessResponseTest {
    private String ID = RandomStringUtils.randomNumeric(10, 25);
    private Integer RESPONSE_CODE = 200;
    private String MESSAGE = RandomStringUtils.randomAlphabetic(5, 30);
    private String TIMESTAMP = new Date().toString();

    @Test
    void testConstructorModel() {
        ObjectSuccessResponse response = initObjectSuccessResponse();
        assertEquals(ID, response.getId());
        assertEquals(RESPONSE_CODE, response.getResponseCode());
        assertEquals(MESSAGE, response.getMessage());
        assertEquals(TIMESTAMP, response.getTimestamp());
    }

    @Test
    void testHashCode() {
        EqualsVerifier.simple().forClass(ObjectSuccessResponse.class).verify();
    }

    private ObjectSuccessResponse initObjectSuccessResponse() {
        ObjectSuccessResponse response = new ObjectSuccessResponse();
        response.id(ID);
        response.responseCode(RESPONSE_CODE);
        response.message(MESSAGE);
        response.timestamp(TIMESTAMP);
        return response;
    }
}
