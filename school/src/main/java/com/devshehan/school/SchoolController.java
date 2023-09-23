package com.devshehan.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    public final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }
    @PostMapping
    public void saveSchool(@RequestBody School school){
        this.schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> getAllSchoolsWithStudents(
            @PathVariable("school-id") Long schoolId
    ){
        return ResponseEntity.ok(schoolService.getAllSchoolsWithStudents(schoolId));
    }
}
