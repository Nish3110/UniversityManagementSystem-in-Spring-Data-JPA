package com.example.codingshuttle.mappingHomework.MappingsHomework.controllers;

import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.AdmissionRecordEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.entities.StudentEntity;
import com.example.codingshuttle.mappingHomework.MappingsHomework.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admissionrecord")
public class AdmissionController {

    private final AdmissionRecordService admissionRecordService;
    public AdmissionController(AdmissionRecordService admissionRecordService){
        this.admissionRecordService=admissionRecordService;
    }
    @GetMapping
    public List<AdmissionRecordEntity>getAdmissionRecords(){
        return admissionRecordService.getAdmissionRecords();
    }
    @PostMapping
    public AdmissionRecordEntity createNewRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.createNewRecord(admissionRecordEntity);
    }
    @PutMapping(path="/{admissionId}/record/{studentId}")
    public AdmissionRecordEntity assignAdmissionToStudent(@PathVariable Long admissionID,
                                                          @PathVariable Long studentId)
    {
        return admissionRecordService.assignAdmissionToStudent(admissionID,studentId);
    }




}
