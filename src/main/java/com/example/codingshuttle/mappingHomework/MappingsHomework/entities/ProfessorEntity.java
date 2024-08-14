package com.example.codingshuttle.mappingHomework.MappingsHomework.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<SubjectEntity> subjects;
    public Set<SubjectEntity> getSubjects() {
        return subjects;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="professor_student_mapping", joinColumns = @JoinColumn(name="professor_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private Set<StudentEntity> students;


    public Set<StudentEntity> getStudents() {
        return students;
    }
}
