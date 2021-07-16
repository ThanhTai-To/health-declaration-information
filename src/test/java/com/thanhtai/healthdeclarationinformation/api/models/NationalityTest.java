package com.thanhtai.healthdeclarationinformation.api.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class NationalityTest {

    @Test
    void testFromValue() {
        assertNull(Nationality.fromValue("Will return null"));
    }
}
