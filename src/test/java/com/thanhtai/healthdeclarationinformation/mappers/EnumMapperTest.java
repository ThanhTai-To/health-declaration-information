package com.thanhtai.healthdeclarationinformation.mappers;

import com.thanhtai.healthdeclarationinformation.api.models.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class EnumMapperTest {

    @Test
    void toStringTest() {
        EnumMapper mapper = new EnumMapper();
        assertNull(mapper.toString(null));
        assertEquals("MALE", mapper.toString(Gender.MALE));
        assertEquals("FEMALE", mapper.toString(Gender.FEMALE));
        assertEquals("OTHER", mapper.toString(Gender.OTHER));
    }

}
