package com.example.codingshuttle.mappingHomework.MappingsHomework.repositories;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
