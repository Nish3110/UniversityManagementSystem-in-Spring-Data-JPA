package com.example.codingshuttle.mappingHomework.MappingsHomework.controllers;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.ProfessorEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }
    @GetMapping
    public List<ProfessorEntity>getAllProfessor(){
        return professorService.getAllProfessor();
    }
    @PostMapping
    public ProfessorEntity  createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }
    @PutMapping(path = "/{professorId}/subjects/{subjectId}")
    public ProfessorEntity assignSubjectToProfessor(@PathVariable Long professorId,
                                                    @PathVariable Long subjectId)
    {
        return professorService.assignSubjectToProfessor(professorId,subjectId);
    }
    @PutMapping(path="/{professorId}/assignstudents/{studentId}")
    public ProfessorEntity assignStudentToProfessor(@PathVariable Long professorId,
                                                    @PathVariable Long studentId)
    {
        return professorService.assignStudentToProfessor(professorId,studentId);
    }
}
