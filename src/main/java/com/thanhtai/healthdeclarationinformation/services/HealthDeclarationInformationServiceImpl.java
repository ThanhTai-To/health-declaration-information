package com.thanhtai.healthdeclarationinformation.services;

import com.thanhtai.healthdeclarationinformation.api.models.HealthDeclarationInformationModel;
import com.thanhtai.healthdeclarationinformation.api.models.ListHealthDeclarationInformation;
import com.thanhtai.healthdeclarationinformation.exceptions.AlreadyExistedException;
import com.thanhtai.healthdeclarationinformation.exceptions.NotFoundException;
import com.thanhtai.healthdeclarationinformation.mappers.HealthDeclarationInformationMapper;
import com.thanhtai.healthdeclarationinformation.mappers.ListHealthDeclarationInformationMapper;
import com.thanhtai.healthdeclarationinformation.models.HealthDeclarationInformation;
import com.thanhtai.healthdeclarationinformation.repositories.HealthDeclarationInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class HealthDeclarationInformationServiceImpl implements HealthDeclarationInformationService {

    private final int PAGE_SIZE = 20;

    @Autowired
    private HealthDeclarationInfoRepository healthDeclarationInfoRepository;

    @Override
    public String createHealthDeclarationInformation(HealthDeclarationInformationModel createRequest) {
        log.info("\nRequest Model: " + createRequest.toString());
        HealthDeclarationInformation healthDeclarationInformation =
                HealthDeclarationInformationMapper.INSTANCE.toHealthDeclarationInformation(createRequest);
        log.info("\nMapped Model: " + healthDeclarationInformation.toString());

        Optional<HealthDeclarationInformation> optionalHealthDeclarationInfo =
                healthDeclarationInfoRepository.findByPhone(healthDeclarationInformation.getPhone());
        if (optionalHealthDeclarationInfo.isPresent()) {
            throw new AlreadyExistedException(healthDeclarationInformation.getPhone());
        }

        HealthDeclarationInformation savedHealthDeclarationInformation =
                healthDeclarationInfoRepository.save(healthDeclarationInformation);
        log.info("\nSave Model: " + savedHealthDeclarationInformation.toString());
        return savedHealthDeclarationInformation.getId();
    }

    @Override
    public void deleteHealthDeclarationInformationById(String id) {
        validateIdNotFound(id);
        healthDeclarationInfoRepository.deleteById(id);
    }

    @Override
    public HealthDeclarationInformationModel getHealthDeclarationInformation(String id) {
        validateIdNotFound(id);
        return HealthDeclarationInformationMapper.INSTANCE
                .toHealthDeclarationInformationModel(
                        healthDeclarationInfoRepository.findHealthDeclarationInformationById(id));
    }

    @Override
    public ListHealthDeclarationInformation getListHealthDeclarationInformation(Integer page) {
        Page<HealthDeclarationInformation> healthDeclarationInfos =
                healthDeclarationInfoRepository.findAllBy(PageRequest.of(page, PAGE_SIZE));
        return ListHealthDeclarationInformationMapper
                .INSTANCE
                .toListHealthDeclarationInformation(healthDeclarationInfos);
    }

    private void validateIdNotFound(String id) {
        Optional<HealthDeclarationInformation> optionalHealthDeclarationInfo =
                healthDeclarationInfoRepository.findById(id);
        if (optionalHealthDeclarationInfo.isEmpty()) {
            throw new NotFoundException(id);
        }
    }


}
