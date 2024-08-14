package com.example.codingshuttle.mappingHomework.MappingsHomework.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private AdmissionRecordEntity admissionRecord;
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<ProfessorEntity> professors;

    public Set<ProfessorEntity> getProfessors() {
        return professors;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject_mapping", joinColumns = @JoinColumn(name = "studentID"),
    inverseJoinColumns = @JoinColumn(name = "subjectID"))
    @JsonIgnore
    private Set<SubjectEntity> subjects;

    public Set<SubjectEntity> getSubjects() {
        return subjects;
    }
}
