package com.example.codingshuttle.mappingHomework.MappingsHomework.repositories;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity, Long > {
    Optional<AdmissionRecordEntity> findById(AdmissionRecordEntity admissionID);
}
