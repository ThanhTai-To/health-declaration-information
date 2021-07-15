package com.thanhtai.healthdeclarationinformation.controller;

import com.thanhtai.healthdeclarationinformation.api.HealthDeclarationInformationApi;
import com.thanhtai.healthdeclarationinformation.api.model.HealthDeclarationInformationRequest;
import com.thanhtai.healthdeclarationinformation.api.model.ObjectSuccessResponse;
import com.thanhtai.healthdeclarationinformation.service.HealthDeclarationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HealthDeclarationInformationController implements HealthDeclarationInformationApi {

    @Autowired
    private HealthDeclarationInformationService healthDeclarationInfoService;

    @Override
    public ResponseEntity<ObjectSuccessResponse> createInformation(@Valid HealthDeclarationInformationRequest healthDeclarationInformationRequest) {
        String id = healthDeclarationInfoService.createHealthDeclarationInformation(healthDeclarationInformationRequest);
        ObjectSuccessResponse objectSuccessResponse = buildObjectSuccessResponse(id);
        return ResponseEntity.ok(objectSuccessResponse);
    }

    private ObjectSuccessResponse buildObjectSuccessResponse(String id) {
        ObjectSuccessResponse response = new ObjectSuccessResponse();
        response.setId(id);
        response.setResponseCode(HttpStatus.OK.value());
        response.setMessage("Successfully");
        response.setTimestamp(Long.toString(System.currentTimeMillis()));
        return response;
    }
}
