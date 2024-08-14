package com.example.codingshuttle.mappingHomework.MappingsHomework.repositories;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findById(StudentEntity studentId);
}
