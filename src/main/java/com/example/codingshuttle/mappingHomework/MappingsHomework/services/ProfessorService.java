package com.example.codingshuttle.mappingHomework.MappingsHomework.services;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.ProfessorEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.StudentEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.SubjectEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.ProfessorRepository;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.StudentRepository;
import com.example.codingshuttle.mappingHomework.MappingsHomework.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    public ProfessorService (ProfessorRepository professorRepository, SubjectRepository subjectRepository, StudentRepository studentRepository){
        this.professorRepository=professorRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<ProfessorEntity> getAllProfessor() {
        return professorRepository.findAll();
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor ->
                subjectEntity.map(subject -> {
                    subject.setProfessor(professor);
                    professor.getSubjects().add(subject); // Corrected this line
                    subjectRepository.save(subject); // Save the subject entity
                    return professorRepository.save(professor); // Save the professor entity
                })).orElse(null);
    }

    public ProfessorEntity assignStudentToProfessor(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        return professorEntity.flatMap(professor ->
               studentEntity.map(student-> {
                   professor.getStudents().add(student);
                   studentRepository.save(student);
                   student.getProfessors().add(professor);
                   professorRepository.save(professor);
                   return professor;
               })).orElse(null);
    }
}
