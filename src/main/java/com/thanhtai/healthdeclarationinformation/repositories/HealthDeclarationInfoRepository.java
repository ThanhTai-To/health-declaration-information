package com.thanhtai.healthdeclarationinformation.repositories;

import com.thanhtai.healthdeclarationinformation.models.HealthDeclarationInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface HealthDeclarationInfoRepository extends MongoRepository<HealthDeclarationInformation, String> {

    Optional<HealthDeclarationInformation> findByPhone(String phone);
    HealthDeclarationInformation findHealthDeclarationInformationById(String id);
    @Query(sort = "{ _id : -1 }")
    Page<HealthDeclarationInformation> findAllBy(Pageable pageable);
}
