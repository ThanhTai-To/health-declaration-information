package com.thanhtai.healthdeclarationinformation.api.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ListHealthDeclarationInformationTest {

    @Test
    void testHashCode() {
        EqualsVerifier.simple().forClass(ListHealthDeclarationInformation.class).verify();
    }
}
