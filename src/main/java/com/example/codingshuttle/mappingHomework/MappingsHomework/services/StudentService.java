package com.example.codingshuttle.mappingHomework.MappingsHomework.services;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.StudentEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.SubjectEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.StudentRepository;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    public StudentService (StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository=studentRepository;
        this.subjectRepository=subjectRepository;
    }
    public List<StudentEntity> getAllStudents() {

            return studentRepository.findAll();
        }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity assignSubjectToStudent(Long studentID, Long subjectID) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentID);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectID);
        return studentEntity.flatMap(student ->
                subjectEntity.map(subject ->{
                    student.getSubjects().add(subject);
                    subject.getStudents().add(student);
                    studentRepository.save(student);
                    subjectRepository.save(subject);

                    return student ;

                })).orElse(null);
    }
}

