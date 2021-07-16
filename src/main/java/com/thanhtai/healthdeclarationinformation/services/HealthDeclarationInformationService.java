package com.thanhtai.healthdeclarationinformation.services;

import com.thanhtai.healthdeclarationinformation.api.models.HealthDeclarationInformationModel;
import com.thanhtai.healthdeclarationinformation.api.models.ListHealthDeclarationInformation;

public interface HealthDeclarationInformationService {
    String createHealthDeclarationInformation(HealthDeclarationInformationModel createRequest);
    void deleteHealthDeclarationInformationById(String id);
    HealthDeclarationInformationModel getHealthDeclarationInformation(String id);
    ListHealthDeclarationInformation getListHealthDeclarationInformation(Integer page);
}
