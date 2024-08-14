package com.example.codingshuttle.mappingHomework.MappingsHomework.services;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.SubjectEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository=subjectRepository;
    }
    public List<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }
}
