package com.thanhtai.healthdeclarationinformation.repository;

import com.thanhtai.healthdeclarationinformation.model.HealthDeclarationInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HealthDeclarationInfoRepository extends MongoRepository<HealthDeclarationInformation, String> {

    Optional<HealthDeclarationInformation> findByPhone(String phone);
}
