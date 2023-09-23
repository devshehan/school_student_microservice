package com.devshehan.student;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudent());
    }
    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudentsBySchoolId(
            @PathVariable("school-id") Long schoolId
    ){
        return ResponseEntity.ok(studentService.findAllStudentStudentsBySchoolId(schoolId));
    }


}
