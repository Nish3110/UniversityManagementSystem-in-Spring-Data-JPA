package com.example.codingshuttle.mappingHomework.MappingsHomework.controllers;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.StudentEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController (StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping
    public List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }
    @PutMapping (path = "/{studentID}/assignsubject/{subjectID}")
    public StudentEntity assignSubjectToStudent(@PathVariable Long studentID,
                                                @PathVariable Long subjectID)
    {
        return studentService.assignSubjectToStudent(studentID, subjectID);
    }

}
