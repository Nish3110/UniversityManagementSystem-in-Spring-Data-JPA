package com.example.codingshuttle.mappingHomework.MappingsHomework.controllers;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.SubjectEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/subject")
public class SubjectController {
    private final SubjectService subjectService;
    public SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }
    @GetMapping
    public List<SubjectEntity> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubject(subjectEntity);
    }

}
