package com.example.codingshuttle.mappingHomework.MappingsHomework.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    @JsonBackReference
    private ProfessorEntity professor;

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
        if (professor != null && !professor.getSubjects().contains(this)) {
            professor.getSubjects().add(this); // Maintain bidirectional consistency
        }
    }
    @ManyToMany(mappedBy = "subjects")
    @JsonIgnore
    public Set<StudentEntity> students;

    public Set<StudentEntity> getStudents() {
        return students;
    }
}
