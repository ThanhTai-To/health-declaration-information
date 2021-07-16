package com.thanhtai.healthdeclarationinformation.controllers;

import com.thanhtai.healthdeclarationinformation.api.models.*;
import com.thanhtai.healthdeclarationinformation.exceptions.AlreadyExistedException;
import com.thanhtai.healthdeclarationinformation.exceptions.NotFoundException;
import com.thanhtai.healthdeclarationinformation.models.HealthDeclarationInformation;

import org.apache.commons.lang3.RandomStringUtils;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthDeclarationInformationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private HealthDeclarationInformationController healthDeclarationInformationController;
    private HealthDeclarationInformation healthDeclarationInformation;


    @BeforeEach
    void setUp() {
        mongoTemplate.remove(HealthDeclarationInformation.class).all();
        this.healthDeclarationInformation = mongoTemplate.save(createHealthDeclarationInformation());
    }

    @Test
    void shouldReturnIdWhenCreateHealthDeclarationInformationSuccess() {
        HealthDeclarationInformationModel createModelRequest =
                createHealthDeclarationInformationModel(null);

        ResponseEntity<ObjectSuccessResponse> response =
                restTemplate.postForEntity("/health-declaration-information", createModelRequest, ObjectSuccessResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response);
        assertEquals("Successfully", response.getBody().getMessage());
        assertNotNull(response.getBody().getId());
    }

    @Test
    void shouldThrowAlreadyExistedExceptionWhenCreateHealthDeclarationInformation() {
        HealthDeclarationInformationModel createModelRequest =
                createHealthDeclarationInformationModel(healthDeclarationInformation.getPhone());
        assertThrows(AlreadyExistedException.class, () -> {
            healthDeclarationInformationController.createInformation(createModelRequest);
        });
    }

    @Test
    void shouldReturnCorrectObjectWhenGetById() {
        ResponseEntity<HealthDeclarationInformationModel> response =
                restTemplate.getForEntity("/health-declaration-information/" + healthDeclarationInformation.getId()
                        , HealthDeclarationInformationModel.class);
        assertNotNull(response.getBody());
        assertEquals(healthDeclarationInformation.getId(), response.getBody().getId());
    }

    @Test
    void shouldReturnListHealthDeclarationInformationWhenGetByPageNumber() {
        ResponseEntity<ListHealthDeclarationInformation> response =
                restTemplate.getForEntity("/health-declaration-information?page=0"
                        , ListHealthDeclarationInformation.class);
        assertNotNull(response.getBody());
        assertEquals(0, response.getBody().getCurrentPage());
        assertEquals(1, response.getBody().getTotalPage());
        assertEquals(1, response.getBody().getTotalElements());
        assertEquals(1, response.getBody().getHealthDeclarationInformations().toArray().length);
    }

    @Test
    void shouldReturnNotFoundExceptionWhenDeleteIdNotExist() {
        assertThrows(NotFoundException.class, () -> {
            healthDeclarationInformationController.deleteHealthDeclarationInformationById(healthDeclarationInformation.getId() + 1);
        });
    }

    @Test
    void shouldEmptyWhenDeleteHealthDeclarationInformation() {
        restTemplate.delete("/health-declaration-information/" + healthDeclarationInformation.getId());
        assertNull(mongoTemplate.findById(new ObjectId(healthDeclarationInformation.getId())
                , HealthDeclarationInformation.class));
    }



    private  HealthDeclarationInformation createHealthDeclarationInformation() {
        Address address = createAddress();
        PersonalQuestionsLast14Days questions = createPersonalQuestionsLast14Days();

        return HealthDeclarationInformation.builder()
                .isRegisterForOther(false)
                .fullName(RandomStringUtils.randomAlphabetic(10, 25))
                .idCardNumber(RandomStringUtils.randomNumeric(9, 12))
                .birthYear("2000")
                .gender("MALE")
                .nationality("VIETNAMESE")
                .address(address)
                .phone(RandomStringUtils.randomNumeric(9, 12))
                .email(RandomStringUtils.randomAlphanumeric(5, 15) + "@gmail.com")
                .personalQuestionsLast14Days(questions)
                .build();
    }

    private HealthDeclarationInformationModel createHealthDeclarationInformationModel(String phone) {
        Address address = createAddress();
        PersonalQuestionsLast14Days questions = createPersonalQuestionsLast14Days();
        HealthDeclarationInformationModel requestModel = new HealthDeclarationInformationModel();
        requestModel.setIsRegisterForOther(false);
        requestModel.setFullName(RandomStringUtils.randomAlphabetic(10, 25));
        requestModel.setIdCardNumber(RandomStringUtils.randomNumeric(9, 12));
        requestModel.setBirthYear("2000");
        requestModel.setGender(Gender.MALE);
        requestModel.setNationality(Nationality.VIETNAMESE);
        requestModel.setAddress(address);
        requestModel.setEmail(RandomStringUtils.randomAlphanumeric(5, 15) + "@gmail.com");
        requestModel.setPersonalQuestionsLast14Days(questions);
        if (phone == null) {
            requestModel.setPhone(RandomStringUtils.randomNumeric(9, 12));
        } else {
            requestModel.setPhone(phone);
        }
        return requestModel;
    }

    private Address createAddress() {
        Address address = new Address();
        address.setProvince(RandomStringUtils.randomAlphabetic(10, 20));
        address.setDistrict(RandomStringUtils.randomAlphanumeric(10, 20));
        address.setWard(RandomStringUtils.randomAlphanumeric(15, 30));
        address.setStreet(RandomStringUtils.randomAlphabetic(10, 30));
        return address;
    }

    private PersonalQuestionsLast14Days createPersonalQuestionsLast14Days() {
        PersonalQuestionsLast14Days questions = new PersonalQuestionsLast14Days();
        questions.setIsTraveling(false);
        questions.setIsContactWithInfectedCovid19Person(false);
        questions.setHaveCovid19Manifestations(false);
        return questions;
    }
}
