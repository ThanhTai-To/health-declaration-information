package com.thanhtai.healthdeclarationinformation.controllers;

import com.thanhtai.healthdeclarationinformation.api.HealthDeclarationInformationApi;
import com.thanhtai.healthdeclarationinformation.api.models.HealthDeclarationInformationModel;
import com.thanhtai.healthdeclarationinformation.api.models.ListHealthDeclarationInformation;
import com.thanhtai.healthdeclarationinformation.api.models.ObjectSuccessResponse;
import com.thanhtai.healthdeclarationinformation.services.HealthDeclarationInformationService;
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
    public ResponseEntity<ObjectSuccessResponse> createInformation(@Valid HealthDeclarationInformationModel healthDeclarationInformationModel) {
        String id = healthDeclarationInfoService
                        .createHealthDeclarationInformation(healthDeclarationInformationModel);
        ObjectSuccessResponse objectSuccessResponse = buildObjectSuccessResponse(id);
        return ResponseEntity.ok(objectSuccessResponse);
    }

    @Override
    public ResponseEntity<ObjectSuccessResponse> deleteHealthDeclarationInformationById(String id) {
        healthDeclarationInfoService.deleteHealthDeclarationInformationById(id);
        ObjectSuccessResponse objectSuccessResponse = buildObjectSuccessResponse(id);
        return ResponseEntity.ok(objectSuccessResponse);
    }

    @Override
    public ResponseEntity<HealthDeclarationInformationModel> getHealthDeclarationInformationByID(String id) {
        return ResponseEntity.ok(healthDeclarationInfoService.getHealthDeclarationInformation(id));
    }

    @Override
    public ResponseEntity<ListHealthDeclarationInformation> getListHealthDeclarationInformation(Integer page) {
        return ResponseEntity.ok(healthDeclarationInfoService
                .getListHealthDeclarationInformation(page));
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
