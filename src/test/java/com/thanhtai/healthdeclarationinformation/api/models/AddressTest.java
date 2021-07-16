package com.thanhtai.healthdeclarationinformation.api.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressTest {

    private final String PROVINCE = "HO CHI MINH";
    private final String DISTRICT = "TAN BINH";
    private final String WARD = "WARD 10";
    private final String STREET = "CONG HOA";

    @Test
    void testConstructorAddress() {
        Address address = initAddress();
        assertEquals(PROVINCE, address.getProvince());
        assertEquals(DISTRICT, address.getDistrict());
        assertEquals(WARD, address.getWard());
        assertEquals(STREET, address.getStreet());
    }

    @Test
    void testHashCode() {
        EqualsVerifier.simple().forClass(Address.class).verify();
    }

    private Address initAddress() {
        Address address = new Address();
        address.province(PROVINCE);
        address.district(DISTRICT);
        address.ward(WARD);
        address.street(STREET);
        return address;
    }
}
