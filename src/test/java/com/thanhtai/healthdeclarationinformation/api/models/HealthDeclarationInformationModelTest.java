package com.thanhtai.healthdeclarationinformation.api.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HealthDeclarationInformationModelTest {

    private final String PROVINCE = "HO CHI MINH";
    private final String DISTRICT = "TAN BINH";
    private final String WARD = "WARD 10";
    private final String STREET = "CONG HOA";

    private String ID = RandomStringUtils.randomNumeric(10, 25);
    private Boolean IS_REGISTER_FOR_OTHER = false;
    private String FULL_NAME = RandomStringUtils.randomAlphabetic(10, 25);
    private String ID_CARD_NUMBER = RandomStringUtils.randomNumeric(10, 25);
    private String BIRTH_YEAR = RandomStringUtils.randomNumeric(4);
    private Gender GENDER = Gender.MALE;
    private Nationality NATIONALITY = Nationality.VIETNAMESE;
    private Address ADDRESS = initAddress();
    private String PHONE = RandomStringUtils.randomNumeric(10);
    private String EMAIL = RandomStringUtils.randomAlphabetic(5, 20) + "@gmail.com";
    private PersonalQuestionsLast14Days QUESTIONS = initPersonalQuestionsLast14Days();

    @Test
    void testConstructorModel() {
        HealthDeclarationInformationModel model = initHealthDeclarationInformationModel();
        assertEquals(ID, model.getId());
        assertEquals(FULL_NAME, model.getFullName());
        assertEquals(ID_CARD_NUMBER, model.getIdCardNumber());
        assertEquals(BIRTH_YEAR, model.getBirthYear());
        assertEquals(GENDER, model.getGender());
        assertEquals(NATIONALITY, model.getNationality());
        assertEquals(ADDRESS, model.getAddress());
        assertEquals(PHONE, model.getPhone());
        assertEquals(EMAIL, model.getEmail());
        assertEquals(QUESTIONS, model.getPersonalQuestionsLast14Days());
    }

    @Test
    void testHashCode() {
        EqualsVerifier.simple().forClass(HealthDeclarationInformationModel.class).verify();
    }

    private HealthDeclarationInformationModel initHealthDeclarationInformationModel() {
        HealthDeclarationInformationModel model = new HealthDeclarationInformationModel();
        model.id(ID);
        model.isRegisterForOther(IS_REGISTER_FOR_OTHER);
        model.fullName(FULL_NAME);
        model.idCardNumber(ID_CARD_NUMBER);
        model.birthYear(BIRTH_YEAR);
        model.gender(GENDER);
        model.nationality(NATIONALITY);
        model.address(ADDRESS);
        model.phone(PHONE);
        model.email(EMAIL);
        model.personalQuestionsLast14Days(QUESTIONS);
        return model;
    }

    private Address initAddress() {
        Address address = new Address();
        address.province(PROVINCE);
        address.district(DISTRICT);
        address.ward(WARD);
        address.street(STREET);
        return address;
    }

    private PersonalQuestionsLast14Days initPersonalQuestionsLast14Days() {
        PersonalQuestionsLast14Days questions = new PersonalQuestionsLast14Days();
        questions.isTraveling(false);
        questions.isContactWithInfectedCovid19Person(false);
        questions.haveCovid19Manifestations(false);
        return questions;
    }
}
