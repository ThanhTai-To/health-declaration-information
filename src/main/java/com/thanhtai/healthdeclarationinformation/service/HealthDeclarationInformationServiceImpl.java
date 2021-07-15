package com.thanhtai.healthdeclarationinformation.service;

import com.thanhtai.healthdeclarationinformation.api.model.HealthDeclarationInformationRequest;
import com.thanhtai.healthdeclarationinformation.exception.AlreadyExistedException;
import com.thanhtai.healthdeclarationinformation.mapper.HealthDeclarationInformationMapper;
import com.thanhtai.healthdeclarationinformation.model.HealthDeclarationInformation;
import com.thanhtai.healthdeclarationinformation.repository.HealthDeclarationInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class HealthDeclarationInformationServiceImpl implements HealthDeclarationInformationService {

    @Autowired
    private HealthDeclarationInfoRepository healthDeclarationInfoRepository;

    @Override
    public String createHealthDeclarationInformation(HealthDeclarationInformationRequest createRequest) {
        log.info("\nRequest Model: " + createRequest.toString());
        HealthDeclarationInformation healthDeclarationInformation =
                HealthDeclarationInformationMapper.INSTANCE.toHealthDeclarationInformation(createRequest);
        log.info("\nMapped Model: " + healthDeclarationInformation.toString());

        Optional<HealthDeclarationInformation> optionalHealthDeclarationInfo =
                healthDeclarationInfoRepository.findByPhone(healthDeclarationInformation.getPhone());
        if (optionalHealthDeclarationInfo.isPresent()) {
            throw new AlreadyExistedException(healthDeclarationInformation.getPhone());
        }
        HealthDeclarationInformation savedHealthDeclarationInformation = healthDeclarationInfoRepository.save(healthDeclarationInformation);
        log.info("\nSave Model: " + savedHealthDeclarationInformation.toString());
        return savedHealthDeclarationInformation.getId();
    }

    @Override
    public HealthDeclarationInformation getHealthDeclarationInformation(String id) {
        return null;
    }
}
