package com.thanhtai.healthdeclarationinformation.service;

import com.thanhtai.healthdeclarationinformation.api.model.HealthDeclarationInformationRequest;
import com.thanhtai.healthdeclarationinformation.model.HealthDeclarationInformation;

public interface HealthDeclarationInformationService {
    String createHealthDeclarationInformation(HealthDeclarationInformationRequest createRequest);
    HealthDeclarationInformation getHealthDeclarationInformation(String id);
}
