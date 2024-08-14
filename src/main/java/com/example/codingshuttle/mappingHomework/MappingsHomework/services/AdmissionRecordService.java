package com.example.codingshuttle.mappingHomework.MappingsHomework.services;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.AdmissionRecordEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.StudentEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.AdmissionRecordRepository;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;
    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository){
        this.admissionRecordRepository=admissionRecordRepository;
        this.studentRepository = studentRepository;
    }
    public List<AdmissionRecordEntity> getAdmissionRecords() {
    return admissionRecordRepository.findAll();
    }


    public AdmissionRecordEntity createNewRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity assignAdmissionToStudent(Long admissionID, Long studentId) {
        Optional<AdmissionRecordEntity>admissionRecordEntity = admissionRecordRepository.findById(admissionID);
        Optional<StudentEntity>studentEntity = studentRepository.findById(studentId);

        return admissionRecordEntity.flatMap(admission ->
                studentEntity.map(student -> {
                    admission.setStudent(student);
                    return admissionRecordRepository.save(admission);
                })).orElse(null);
    }
}
