package com.example.codingshuttle.mappingHomework.MappingsHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fees;
    @OneToOne
    @JoinColumn(name = "studentadmissionrecord")
    private StudentEntity student;

    public void setStudent(StudentEntity student) {

    }
}
