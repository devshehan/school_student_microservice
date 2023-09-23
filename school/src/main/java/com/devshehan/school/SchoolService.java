package com.devshehan.school;

import com.devshehan.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;




    public void saveSchool(School school){
        this.schoolRepository.save(school);
    }

    public List<School> getAllSchools(){
        return this.schoolRepository.findAll();
    }

    public FullSchoolResponse getAllSchoolsWithStudents(Long schoolId){
        var school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new IllegalStateException("School not found"));

        var students =  studentClient.findAllStudentsById(schoolId);

        return new FullSchoolResponse(school.getName(),school.getEmail(),students);
    }

}
