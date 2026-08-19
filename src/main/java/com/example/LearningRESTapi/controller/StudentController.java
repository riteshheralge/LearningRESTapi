package com.example.LearningRESTapi.controller;

import com.example.LearningRESTapi.dto.AddStudentDto;
import com.example.LearningRESTapi.dto.StudentDto;
import com.example.LearningRESTapi.entity.Student;
import com.example.LearningRESTapi.repository.StudentRepository;
import com.example.LearningRESTapi.service.StudentService;
import com.example.LearningRESTapi.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentsById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentsById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentDto addStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addStudentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
