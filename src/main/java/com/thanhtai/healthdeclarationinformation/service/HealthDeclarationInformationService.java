package com.thanhtai.healthdeclarationinformation.service;

import com.thanhtai.healthdeclarationinformation.api.model.HealthDeclarationInformationModel;
import com.thanhtai.healthdeclarationinformation.api.model.ListHealthDeclarationInformation;

public interface HealthDeclarationInformationService {
    String createHealthDeclarationInformation(HealthDeclarationInformationModel createRequest);
    void deleteHealthDeclarationInformationById(String id);
    HealthDeclarationInformationModel getHealthDeclarationInformation(String id);
    ListHealthDeclarationInformation getListHealthDeclarationInformation(Integer page);
}
