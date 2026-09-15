package com.example.LearningRESTapi.service;

import com.example.LearningRESTapi.dto.AddStudentDto;
import com.example.LearningRESTapi.dto.StudentDto;
import java.util.*;

public interface StudentService {
 List<StudentDto> getAllStudents();
 StudentDto getStudentsById(Long id);

 StudentDto createStudent(AddStudentDto addStudentDto);

 void deleteStudentById(Long id);

 StudentDto updateStudent(Long id, AddStudentDto addStudentDto);

 StudentDto updatePartialStudent(Long id,Map<String,Object> update);
}
