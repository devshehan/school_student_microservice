package com.devshehan.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentStudentsBySchoolId(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
