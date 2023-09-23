package com.devshehan.school.client;

import com.devshehan.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "http://localhost:8990/api/v1/students")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    public List<Student> findAllStudentsById(@PathVariable("school-id") Long schoolId);
}
